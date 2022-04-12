CRGB* gradient(int _length, CRGB color1, CRGB color2){
  int changeInRed = (color2.r - color1.r)/_length;
  int changeInGreen = (color2.g - color1.g)/_length;
  int changeInBlue = (color2.b - color1.b)/_length;

  CRGB _array[_length];

  for (int x = 0; x < _length; x++){
     _array[x].r = color1.r + changeInRed*x;
     _array[x].g = color1.g + changeInGreen*x;
     _array[x].b = color1.b + changeInBlue*x;
  }

  return _array;
}

void gradient(CRGB color1, CRGB color2){
  int changeInRed = (color2.r - color1.r)/NUM_LEDS;
  int changeInGreen = (color2.g - color1.g)/NUM_LEDS;
  int changeInBlue = (color2.b - color1.b)/NUM_LEDS;

  for (int x = 0; x < NUM_LEDS; x++){
     leds[x].r = color1.r + changeInRed*x;
     leds[x].g = color1.g + changeInGreen*x;
     leds[x].b = color1.b + changeInBlue*x;
  }
  FastLED.show();
}

void double_gradient(CRGB color1, CRGB color2){
  CRGB array1[NUM_LEDS/2] = gradient(NUM_LEDS/2, color1, color2);
  CRGB array2[NUM_LEDS/2] = gradient(NUM_LEDS/2, color2, color1);

  for (int x = 0; x < NUM_LEDS/2; x++){
     leds[x].r = array1[x].r;
     leds[x].g = array1[x].g;
     leds[x].b = array1[x].b;
  }

  for (int x = NUM_LEDS/2; x < NUM_LEDS; x++){
     leds[x].r = array2[x].r;
     leds[x].g = array2[x].g;
     leds[x].b = array2[x].b;
  }
  FastLED.show();
}
