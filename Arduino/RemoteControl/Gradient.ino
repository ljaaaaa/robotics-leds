void gradient(CRGB color1, CRGB color2){
  int changeInRed = (color1.r - color2.r)/NUM_LEDS;
  int changeInGreen = (color1.g - color2.g)/NUM_LEDS;
  int changeInBlue = (color1.b - color2.b)/NUM_LEDS;
  
  for (int x = 0; x < NUM_LEDS; x++){
     leds[x].r = color1.r + changeInRed*x;
     leds[x].g = color1.g + changeInGreen*x;
     leds[x].b = color1.b + changeInBlue*x;
  }
  FastLED.show();
}
