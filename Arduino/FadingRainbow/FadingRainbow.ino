/* Fading rainbow
 * Makes a faded rainbow on all LEDs
 */
#include "FastLED.h"
#include "FastLED_RGBW.h"

#define NUM_LEDS 30
#define DATA_PIN 8

CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];

CRGB colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};

const uint8_t brightness = 128;

void setup() {
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS));
  FastLED.setBrightness(brightness);
}

void loop(){
  int r = 255;
  int g = 0;
  int b = 0;
  
  //Red to yellow
  for (int x = 0; x < 255; x++){
    g++;
    paintLED(0, r, g, b);
    FastLED.show();  
  }

  //Yellow to green
  for (int x = 0; x < 255; x++){
    r--;
    paintLED(0, r, g, b);
    FastLED.show();  
  }

  //Green to light blue
  for (int x = 0; x < 255; x++){
    b++;
    paintLED(0, r, g, b);
    FastLED.show();  
  }

  //Light green to blue
  for (int x = 0; x < 255; x++){
    g--;
    paintLED(0, r, g, b);
    FastLED.show();  
  }

  //Blue to pink
  for (int x = 0; x < 255; x++){
    r++;
    paintLED(0, r, g, b);
    FastLED.show();  
  }

  //Pink to purple
  for (int x = 0; x < 255; x++){
    b--;
    paintLED(0, r, g, b);
    FastLED.show();  
  }
}

void paintLED(int pos, int r, int g, int b){
  leds[pos].r = r;
  leds[pos].g = g;
  leds[pos].b = b;
}

void paintLEDs(int r, int g, int b){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x].r = r;
    leds[x].g = g;
    leds[x].b = b;
  }
  FastLED.show();
}
