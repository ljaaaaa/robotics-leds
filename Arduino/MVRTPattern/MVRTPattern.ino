/* MVRT Patter
 * Show MVRT colors pattern on LEDs
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
  MVRT_pattern();
}

void MVRT_pattern(){
  for (int x = 0; x < NUM_LEDS; x++){
    if (x%2 == 0){
      leds[x] = CRGB(0xFFC410);
    } else {
      leds[x] = CRGB(0x260235);
    }
    FastLED.show(); 
    delay(30);
  }
}
