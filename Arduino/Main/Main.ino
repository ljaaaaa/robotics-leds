#include "FastLED.h"

//Pins
#define DATA_PIN 8

//Leds
#define NUM_LEDS 56
CRGB leds[NUM_LEDS];
const uint8_t brightness = 60;

void setup(){
  Serial.begin(9600);

  FastLED.addLeds<WS2812B, DATA_PIN, GRB>(leds, NUM_LEDS); //for GRB LEDs
  FastLED.setBrightness(brightness);

  fading_rainbow();

  FastLED.show();
}

void loop(){
  move_leds();
  delay(100);
  FastLED.show();
}
