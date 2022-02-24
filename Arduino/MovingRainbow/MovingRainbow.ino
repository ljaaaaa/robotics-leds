/* Moving Rainbow
 * Move rainbow through LED strip
 */
#include "FastLED.h"
#include "FastLED_RGBW.h"

#define NUM_LEDS 60
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
  moving_rainbow();
}

void move_colors(){
  CRGB old[6] = colors;
  
  for (int x = 0; x < 6; x++){
    if (x == 5){
      colors[x] = old[0];
      
    } else {
      colors[x] = old[x+1]; 
    }
  }
}

void moving_rainbow(){
  move_colors();
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = colors[x%6];
  }

  FastLED.show(); 
}
