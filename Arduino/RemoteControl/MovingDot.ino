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
