void gradient(int startPos, int endPos, CRGB color1, CRGB color2){
  int len = endPos-startPos;
  
  int changeInRed = (color2.r - color1.r)/(len-1);
  int changeInGreen = (color2.g - color1.g)/(len-1);
  int changeInBlue = (color2.b - color1.b)/(len-1);

  for (int x = 0; startPos+x < endPos; x++){
     leds[startPos+x].r = color1.r + changeInRed*x;
     leds[startPos+x].g = color1.g + changeInGreen*x;
     leds[startPos+x].b = color1.b + changeInBlue*x;
  }
}
