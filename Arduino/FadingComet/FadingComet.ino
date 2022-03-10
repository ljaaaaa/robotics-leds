/* Fading Comet
 * - Moves a comet through LEDs
 */
#include "FastLED.h"
#include "FastLED_RGBW.h"

#define NUM_LEDS 300
#define DATA_PIN 8

CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];

CRGB colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};

const uint8_t brightness = 128;
int pos;

void setup() {
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS));
  FastLED.setBrightness(brightness);

  int num_colors = 6; //red, orange, yellow, green, blue, purple
  int num_segments = NUM_LEDS/num_colors; //segments of each color
  
  int r = 255;
  int g = 0;
  int b = 255;

  //Pink to purple
  for (int x = 0; x < num_segments; x++){
    b -= 255/num_segments;
    paintLED(r, g, b);
  }
  
  //Red to yellow
  for (int x = 0; x < num_segments; x++){
    g += 255/num_segments;
    paintLED(r, g, b);
  }

  //Yellow to green
  for (int x = 0; x < num_segments; x++){
    r -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Green to light blue
  for (int x = 0; x < num_segments; x++){
    b += 255/num_segments;
    paintLED(r, g, b);
  }

  //Light green to blue
  for (int x = 0; x < num_segments; x++){
    g -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Blue to pink
  for (int x = 0; x < num_segments; x++){
    r += 255/num_segments;
    paintLED(r, g, b);
  }

  FastLED.show();
}

void loop(){
  
}

void paintLED(int r, int g, int b){
  leds[pos].r = r;
  leds[pos].g = g;
  leds[pos].b = b;
  pos++;
  FastLED.show();
}
