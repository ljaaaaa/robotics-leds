void still_fading_rainbow() {
  FastLED.addLeds<WS2812B, DATA_PIN, RGB>(ledsRGB, getRGBWsize(NUM_LEDS));
  FastLED.setBrightness(brightness);

  int num_colors = 6; //red, orange, yellow, green, blue, purple
  int num_segments = NUM_LEDS/num_colors; //segments of each color
  
  int r = 255;
  int g = 0;
  int b = 255;

  //Pink to purple
  for (int x = 0; x < num_segments; x++){
    b -= 255/num_segments;
    paintLED(r, g, b);
  }
  
  //Red to yellow
  for (int x = 0; x < num_segments; x++){
    g += 255/num_segments;
    paintLED(r, g, b);
  }

  //Yellow to green
  for (int x = 0; x < num_segments; x++){
    r -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Green to light blue
  for (int x = 0; x < num_segments; x++){
    b += 255/num_segments;
    paintLED(r, g, b);
  }

  //Light green to blue
  for (int x = 0; x < num_segments; x++){
    g -= 255/num_segments;
    paintLED(r, g, b);
  }

  //Blue to pink
  for (int x = 0; x < num_segments; x++){
    r += 255/num_segments;
    paintLED(r, g, b);
  }

  FastLED.show();
}
