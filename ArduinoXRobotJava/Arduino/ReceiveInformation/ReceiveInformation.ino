#include "FastLED.h"
#include "FastLED_RGBW.h"

#define DATA_PIN 8
#define NUM_LEDS 300

CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];
const uint8_t brightness = 128;

boolean signalReceived = false;

void setup(){
  Serial.begin(9600);

  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS)); //Init LEDs
  FastLED.setBrightness(brightness);
  clear_leds();
  leds[0] = CRGB::Red;
}

void loop() {
  if (Serial.available()){
    byte value = Serial.read();

    switch (value){
      case 0x0:
        bouncing_dot();
        break;
       case 0x1:
        fading_comet();
        break;
       case 0x2:
        fading_rainbow();
        break;
       case 0x3:
        fill_all(CRGB::Green);
        break;
       case 0x4:
        MVRT_pattern();
        break;
       case 0x5:
        moving_dot();
        break;
       case 0x6:
        moving_rainbow();
        break;
       case 0x7:
        still_fading_rainbow();
        break;
    }
  }
  FastLED.show();
}

void clear_leds(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::Black;
  }
  FastLED.show();
}
