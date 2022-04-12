void gradient(CRGB color1, CRGB color2){
  int changeInRed = (color2.r - color1.r)/(NUM_LEDS-1);
  int changeInGreen = (color2.g - color1.g)/(NUM_LEDS-1);
  int changeInBlue = (color2.b - color1.b)/(NUM_LEDS-1);

  for (int x = 0; x < NUM_LEDS; x++){
     leds[x].r = color1.r + changeInRed*x;
     leds[x].g = color1.g + changeInGreen*x;
     leds[x].b = color1.b + changeInBlue*x;
  }
  FastLED.show();
}

void gradient2(int startPos, int endPos, CRGB color1, CRGB color2){
  int len = endPos-startPos;
  
  int changeInRed = (color2.r - color1.r)/(len-1);
  int changeInGreen = (color2.g - color1.g)/(len-1);
  int changeInBlue = (color2.b - color1.b)/(len-1);

  for (int x = 0; startPos+x < endPos; x++){
     leds[startPos+x].r = color1.r + changeInRed*x;
     leds[startPos+x].g = color1.g + changeInGreen*x;
     leds[startPos+x].b = color1.b + changeInBlue*x;
  }
  FastLED.show();
}
