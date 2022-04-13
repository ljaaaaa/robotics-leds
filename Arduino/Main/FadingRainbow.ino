void fading_rainbow(){
  int x = NUM_LEDS/7; //For each section of color
  gradient2(0, x, CRGB::Red, CRGB::Orange);
  gradient2(x, x*2, CRGB::Orange, CRGB::Yellow);
  gradient2(x*2, x*3, CRGB::Yellow, CRGB::Green);
  gradient2(x*3, x*4, CRGB::Green, CRGB::Blue);
  gradient2(x*4, x*5, CRGB::Blue, CRGB::Purple);
  gradient2(x*5, x*6, CRGB::Purple, CRGB::Pink);
  gradient2(x*6, x*7, CRGB::Pink, CRGB::Red);
}
