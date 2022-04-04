#include "IRremote.h"
#include "FastLED.h"
#include "FastLED_RGBW.h"

//Pins
#define RECEIVER_PIN 11
#define DATA_PIN 8

//Leds
#define NUM_LEDS 100
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

void all(){
   morse_code();
  delay(1000);
  bouncing_dot();
  delay(1000);
  fading_rainbow();
  delay(1000);
  fill_all(CRGB::Green);
  delay(1000);
  mvrt_pattern();
  delay(1000);
  moving_rainbow();
  delay(1000);
}

void loop(){
  //if (irrecv.decode(&results)){ //Signal recieved
  //  translateIR(); 
  //  irrecv.resume(); // Receive the next signal
  //}  
}

void clear_leds(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::Black; 
  }
  FastLED.show();
}

void translateIR() {
  switch(results.value) {

    case 0xFF6897: //0
      bouncing_dot();      
      break;
    case 0xFF30CF: //1
      fading_rainbow();
      break;
    case 0xFF18E7: //2
      fill_all(CRGB::Blue);      
      break;
    case 0xFF7A85: //3
      mvrt_pattern();
      break;
    case 0xFF10EF: //4    
      moving_rainbow();   
      break;
    case 0xFF38C7: //5
      break;
    case 0xFF5AA5: //6  
      break;
    case 0xFF42BD: //7  
      break;
    case 0xFF4AB5: //8    
      break;
    case 0xFF52AD: //9    
      break;
  }
  FastLED.show();
  delay(500); // Do not get immediate repeat
}
