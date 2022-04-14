CRGB rainbow_colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};

void moving_rainbow(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = rainbow_colors[x%6];
  }
}
