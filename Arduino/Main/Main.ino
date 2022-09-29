#include "FastLED.h"

//Pins
#define DATA_PIN 7

//Leds
#define NUM_LEDS 100
CRGB leds[NUM_LEDS];
const uint8_t brightness = 60;

void setup(){
  Serial.begin(9600);

  //Mine
  FastLED.addLeds<WS2812B, DATA_PIN, GRB>(leds, NUM_LEDS); //for GRB LEDs
  
  //Maybe MVRTs?
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(leds, NUM_LEDS);
  
  //Also maybe
  FastLED.addLeds<NEOPIXEL, DATA_PIN>(leds, NUM_LEDS);

  FastLED.setBrightness(brightness);

  fading_rainbow();
  //mvrt_pattern();
  //clap();

  FastLED.show();
}

void loop(){
  move_leds();
  delay(50);
  FastLED.show();
}
