void fill_all(CRGB color){
  for(int x = 0; x < NUM_LEDS; x++){
    leds[x] = color;
    FastLED.show();
    delay(0);
  }
  delay(500);
}
