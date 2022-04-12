void moving_gradient(){
  CRGB gradient[NUM_LEDS];
  for (int x = 0; x < NUM_LEDS; x++){
    gradient[x].r = leds[x].r;
    gradient[x].g = leds[x].g;
    gradient[x].b = leds[x].b;
  }

  for (int x = 0; x < NUM_LEDS; x++){
    //gradient = move_array(gradient, NUM_LEDS);
    FastLED.show();
    delay(50);
  }
}
