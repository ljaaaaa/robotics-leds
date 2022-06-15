void move_leds(){
  CRGB old_array[NUM_LEDS] = leds;
  
  for (int x = 0; x < NUM_LEDS; x++){
    if (x == NUM_LEDS-1){
      leds[x] = old_array[0];
      
    } else {
      leds[x] = old_array[x+1];
    }
  }
}
