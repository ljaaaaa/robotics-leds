void fading_rainbow(){
  int r = 255;
  int g = 0;
  int b = 0;
  
  //Red to yellow
  for (int x = 0; x < 255; x++){
    g++;
    paintLEDs(r, g, b);
  }

  //Yellow to green
  for (int x = 0; x < 255; x++){
    r--;
    paintLEDs(r, g, b);
  }

  //Green to light blue
  for (int x = 0; x < 255; x++){
    b++;
    paintLEDs(r, g, b);
  }

  //Light green to blue
  for (int x = 0; x < 255; x++){
    g--;
    paintLEDs(r, g, b);
  }

  //Blue to pink
  for (int x = 0; x < 255; x++){
    r++;
    paintLEDs(r, g, b);
  }

  //Pink to purple
  for (int x = 0; x < 255; x++){
    b--;
    paintLEDs(r, g, b);
  }
}

void paintLEDs(int r, int g, int b){
  for (int x = 0; x < NUM_LEDS-1; x++){
    leds[x].r = r;
    leds[x].g = g;
    leds[x].b = b;
  }
  FastLED.show();
}
