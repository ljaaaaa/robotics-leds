#include "FastLED.h"

#define NUM_LEDS 30
#define DATA_PIN 8
#define BRIGHTNESS 70

//For moving_comet()
CRGB comet[4] {CRGB::White, CRGB::Red, CRGB::Orange, CRGB::Yellow};
int comet_pos[5] = {4, 3, 2, 1, 0};

//For moving_rainbow()
CRGB colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};
CRGB leds[NUM_LEDS];

void setup() { 
  FastLED.addLeds<NEOPIXEL, DATA_PIN>(leds, NUM_LEDS);
  FastLED.setBrightness(BRIGHTNESS);
}

void loop(){
  moving_rainbow();
  FastLED.show();
  delay(100);
}

//Moves comet across LED strip
void moving_comet(){
  increase_comet_pos();

  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::Black;
  }

  for (int x = 0; x < 4; x++){
    leds[comet_pos[x]] = comet[x];
  }
  FastLED.show(); 
  delay(50);
}

void increase_comet_pos(){
  for (int x = 0; x < 4; x++){
    comet_pos[x]++;
    
    if (comet_pos[x] >= NUM_LEDS){
      comet_pos[x] = 0;
    }
  }
}

//Moves a single dot accross strip
void moving_dot(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::White;
    
    if (x == 0){
      leds[NUM_LEDS-1] = CRGB::Black;
    } else {
      leds[x-1] = CRGB::Black;
    }
    FastLED.show(); 
    delay(50);
  }
}

//Moving rainbow
void moving_rainbow(){
  move_colors();
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = colors[x%6];
  }

  FastLED.show(); 
}

//Move the colors array
void move_colors(){
  CRGB old[6] = colors;
  
  for (int x = 0; x < 6; x++){
    if (x == 5){
      colors[x] = old[0];
      
    } else {
      colors[x] = old[x+1]; 
    }
  }
}

//Simple back-forth pattern
void simple_pattern(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] =  CRGB::Green;
    FastLED.show(); 
    delay(30);
  }
  
  for (int x = NUM_LEDS-1; x > -1; x--){
    leds[x] =  CRGB::Black;
    FastLED.show(); 
    delay(30);
  }
}

//MVRT pattern
void MVRTPattern(){
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
