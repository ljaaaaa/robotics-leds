void fill_all(CRGB color){
  for(int x = 0; x < NUM_LEDS; x++){
    leds[x].r = color.r;
    leds[x].b = color.b;
    leds[x].g = color.g;
    FastLED.show();
    delay(0);
  }
  delay(500);
}
