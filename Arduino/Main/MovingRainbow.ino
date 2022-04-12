CRGB colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};

void moving_rainbow(){
  move_array(colors, 6);
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = colors[x%6];
  }

  FastLED.show(); 
}
