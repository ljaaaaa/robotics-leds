void bouncing_dot() {
  for (int dir = 1, cnt = 0; cnt < 2; dir *= -1, cnt++){
    for (int i = (cnt ? NUM_LEDS - 1 : 0); 0 <= i && i < NUM_LEDS; i += dir) {
      int p = i - dir;
      leds[i] = CRGBW{0, 0, 0, 255};
      if (0 <= p && p < NUM_LEDS)
        leds[p] = CRGBW{0, 0, 0, 0};
      FastLED.show();
    }
  }
}
