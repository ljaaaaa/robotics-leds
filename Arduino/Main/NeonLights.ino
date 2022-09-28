CRGB red = CRGB(0xff0000);
CRGB orange = CRGB(0xff8600);
CRGB yellow = CRGB(0xf3ff00);
CRGB pink = CRGB(0xff008f);
CRGB purple = CRGB(0xff00f3);

CRGB neon_colors[5] {red, pink, orange, yellow, purple};

void neon_gradient(){
  int x = NUM_LEDS/5; //For each section of color
  gradient(0, x, red, orange);
  gradient(x, x*2, orange, yellow);
  gradient(x*2, x*3, yellow, pink);
  gradient(x*3, x*4, pink, purple);
  gradient(x*4, x*5, purple, red);
}

void neon_pattern(){
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = neon_colors[x%5];
  }
}