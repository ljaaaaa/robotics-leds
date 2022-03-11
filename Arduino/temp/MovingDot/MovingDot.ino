/* Moving Dot
 * Moves a single dot along LEDs
 */
#include "FastLED.h"
#include "FastLED_RGBW.h"

#define NUM_LEDS 300
#define DATA_PIN 8

CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];

const uint8_t brightness = 128;

void setup() {
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS));
  FastLED.setBrightness(brightness);
}

void loop(){
  moving_dot();
}

void moving_dot(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::White;
    
    if (x == 0){
      leds[NUM_LEDS-1] = CRGB::Black;
    } else {
      leds[x-1] = CRGB::Black;
    }
    FastLED.show(); 
    delay(10);
  }
}
