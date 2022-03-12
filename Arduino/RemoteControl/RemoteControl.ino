#include "IRremote.h"
#include "FastLED.h"
#include "FastLED_RGBW.h"

//Pins
#define RECEIVER_PIN 11
#define DATA_PIN 8

//Leds
#define NUM_LEDS 300
CRGBW leds[NUM_LEDS];
CRGB *ledsRGB = (CRGB *) &leds[0];
const uint8_t brightness = 128;

//Receiver
IRrecv irrecv(RECEIVER_PIN);
decode_results results;

void setup(){
  Serial.begin(9600);
  irrecv.enableIRIn(); //Init receiver

  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS)); //Init LEDs
  FastLED.setBrightness(brightness);
}

void loop(){
  leds[0] = CRGB::Red;
  FastLED.show();
  
  if (irrecv.decode(&results)){ //Signal recieved
    translateIR(); 
    irrecv.resume(); // Receive the next signal
  }  
}

void translateIR() {
  switch(results.value) {

    case 0xFF6897: //0
      bouncing_dot();   
      Serial.print("0");   
      break;
    case 0xFF30CF: //1
      fading_comet();
      Serial.print("1");    
      break;
    case 0xFF18E7: //2
      fading_rainbow();   
      Serial.print("2");   
      break;
    case 0xFF7A85: //3
      fill_all(CRGB::Blue);
      Serial.print("3");     
      break;
    case 0xFF10EF: //4    
      MVRT_pattern();
      Serial.print("4");   
      break;
    case 0xFF38C7: //5
      moving_dot();
      Serial.print("5");
      break;
    case 0xFF5AA5: //6  
      moving_rainbow();
      Serial.print("6");
      break;
    case 0xFF42BD: //7  
      still_fading_rainbow();
      Serial.print("7");
      break;
    case 0xFF4AB5: //8    
      break;
    case 0xFF52AD: //9    
      break;
  }
  FastLED.show();
  delay(500); // Do not get immediate repeat
}
