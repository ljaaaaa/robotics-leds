#include "FastLED.h"
#include "FastLED_RGBW.h"

//Pins
#define DATA_PIN 8

//Leds
#define NUM_LEDS 75
CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];
const uint8_t brightness = 128;

void setup(){
  Serial.begin(9600);

  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS)); //Init LEDs
  FastLED.setBrightness(brightness);

  //gradient2(0, NUM_LEDS/2, CRGB::Purple, CRGB::Yellow);
  //gradient2(NUM_LEDS/2, NUM_LEDS, CRGB::Yellow, CRGB::Purple);
  //fading_rainbow();
  //neon_gradient();
  //neon_pattern();
  morse_code();
  FastLED.show();
}

void loop(){
  move_leds();
  delay(100);
  FastLED.show();
}

void clear_leds(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::Black; 
  }
}
