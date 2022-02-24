/* FillAll
 * Fill the entire LED strip to one color
 */
#include "FastLED.h"
#include "FastLED_RGBW.h"

#define NUM_LEDS 60
#define DATA_PIN 8

CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];

const uint8_t brightness = 128;

void setup() {
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS));
  FastLED.setBrightness(brightness);
}

void loop(){
  fill_color(CRGB::Blue);
}

void fill_color(CRGB color){
  for(int x = 0; x < NUM_LEDS; x++){
    leds[x] = color;
    FastLED.show();
    delay(50);
  }
  delay(500);
}
