void move_array(CRGB _array[], int arr_size){
  CRGB old_array[arr_size];// = _array;

  for (int x = 0; x < arr_size; x++){
    old_array[x] = _array[x];
  }
  
  for (int x = 0; x < arr_size; x++){
    if (x == arr_size-1){
      _array[x] = old_array[0];
      
    } else {
      _array[x] = old_array[x+1];
    }
  }
}

void move_leds(){
  CRGBW old_array[NUM_LEDS] = leds;
  
  for (int x = 0; x < NUM_LEDS; x++){
    if (x == NUM_LEDS-1){
      leds[x] = old_array[0];
      
    } else {
      leds[x] = old_array[x+1];
    }
  }
}
