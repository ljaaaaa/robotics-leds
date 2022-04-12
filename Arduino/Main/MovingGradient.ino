void moving_gradient(){
  CRGB gradient[NUM_LEDS];
  for (int x = 0; x < NUM_LEDS; x++){
    gradient[x].r = leds[x].r;
    gradient[x].g = leds[x].g;
    gradient[x].b = leds[x].b;
  }

  for (int x = 0; x < NUM_LEDS; x++){
    move_array(gradient, NUM_LEDS);
    set_leds(gradient, NUM_LEDS);
    delay(100);
  }
}

void set_leds(CRGB _array[], int arr_size){
  for (int x = 0; x < arr_size; x++){
    leds[x].r = _array[x].r;
    leds[x].g = _array[x].g;
    leds[x].b = _array[x].b;
  }
  FastLED.show();
}
