void fill_all(CRGB color){
  for(int x = 0; x < NUM_LEDS; x++){
    leds[x] = color;
  }
}

void clap(){
  flash(CRGB::Yellow, 240);
  flash(CRGB::Yellow, 240);

  flash(CRGB::Yellow, 100);
  flash(CRGB::Yellow, 100);
  flash(CRGB::Yellow, 100);
}

void flash(CRGB color, int _length){
  fill_all(color);
  FastLED.show();
  delay(_length);

  fill_all(CRGB::Black);
  FastLED.show();
  delay(_length);
}

void clear_leds(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = CRGB::Black; 
  }
}
