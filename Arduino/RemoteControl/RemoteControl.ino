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
int pos = 0;

IRrecv irrecv(RECEIVER_PIN);
decode_results results;

void setup(){
  Serial.begin(9600);
  
  irrecv.enableIRIn(); //Init receiver

  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS)); //Init LEDs
  FastLED.setBrightness(brightness);
}


void loop(){
  if (irrecv.decode(&results)){ //Signal recieved
    translateIR(); 
    irrecv.resume(); // receive the next value
  }  
}

void translateIR() {
  switch(results.value) {
    case 0xFF6897: 
      Serial.println("0");   
      moving_dot();
      break;
    case 0xFF30CF: 
      Serial.println("1");
      //bouncing_dot();    
      break;
    case 0xFF18E7: 
      Serial.println("2"); 
      fading_comet();   
      break;
    case 0xFF7A85: Serial.println("3");    break;
    case 0xFF10EF: Serial.println("4");    break;
    case 0xFF38C7: Serial.println("5");    break;
    case 0xFF5AA5: Serial.println("6");    break;
    case 0xFF42BD: Serial.println("7");    break;
    case 0xFF4AB5: Serial.println("8");    break;
    case 0xFF52AD: Serial.println("9");    break;
    case 0xFFFFFFFF: Serial.println(" REPEAT");break;  
    default: Serial.println(" other button   ");
  }
  delay(500); // Do not get immediate repeat
}



void clear_leds() {
  for (int i = 0; i < NUM_LEDS; i++){
    leds[i] = CRGBW{0, 0, 0, 0};
  }
}

void paintLED(int r, int g, int b){
  leds[pos].r = r;
  leds[pos].g = g;
  leds[pos].b = b;
  pos++;
  FastLED.show();
}

void paintLEDs(int r, int g, int b){
  for (int x = 0; x < NUM_LEDS-1; x++){
    leds[x].r = r;
    leds[x].g = g;
    leds[x].b = b;
  }
  FastLED.show();
}

void bouncing_dot() {
  clear_leds();
  for (int turns = 0; turns < 10; turns++) {
    for (int dir = 1, cnt = 0; cnt < 2; dir *= -1, cnt++){
      for (int i = (cnt ? NUM_LEDS - 1 : 0); 0 <= i && i < NUM_LEDS; i += dir) {
        int p = i - dir;
        leds[i] = CRGBW{0, 0, 0, 255};
        if (0 <= p && p < NUM_LEDS)
          leds[p] = CRGBW{0, 0, 0, 0};
        FastLED.show();
        delay(10);
      }
    }
  }
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

void fading_comet(){
  int num_colors = 6; //red, orange, yellow, green, blue, purple
  int num_segments = NUM_LEDS/num_colors; //segments of each color
  
  int r = 255;
  int g = 0;
  int b = 255;

  //Pink to purple
  for (int x = 0; x < num_segments; x++){
    b -= 255/num_segments;
    paintLED(r, g, b);
  }
  
  //Red to yellow
  for (int x = 0; x < num_segments; x++){
    g += 255/num_segments;
    paintLED(r, g, b);
  }

  //Yellow to green
  for (int x = 0; x < num_segments; x++){
    r -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Green to light blue
  for (int x = 0; x < num_segments; x++){
    b += 255/num_segments;
    paintLED(r, g, b);
  }

  //Light green to blue
  for (int x = 0; x < num_segments; x++){
    g -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Blue to pink
  for (int x = 0; x < num_segments; x++){
    r += 255/num_segments;
    paintLED(r, g, b);
  }
  FastLED.show();
}

void fading_rainbow(){
int r = 255;
  int g = 0;
  int b = 0;
  
  //Red to yellow
  for (int x = 0; x < 255; x++){
    g++;
    paintLEDs(r, g, b);
  }

  //Yellow to green
  for (int x = 0; x < 255; x++){
    r--;
    paintLEDs(r, g, b);
  }

  //Green to light blue
  for (int x = 0; x < 255; x++){
    b++;
    paintLEDs(r, g, b);
  }

  //Light green to blue
  for (int x = 0; x < 255; x++){
    g--;
    paintLEDs(r, g, b);
  }

  //Blue to pink
  for (int x = 0; x < 255; x++){
    r++;
    paintLEDs(r, g, b);
  }

  //Pink to purple
  for (int x = 0; x < 255; x++){
    b--;
    paintLEDs(r, g, b);
  }
}
