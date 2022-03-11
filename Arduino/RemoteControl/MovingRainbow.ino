CRGB colors[6] {CRGB::Red, CRGB::Orange, CRGB::Yellow, CRGB::Green, CRGB::Blue, CRGB::Purple};

void move_colors(){
  CRGB old[6] = colors;
  
  for (int x = 0; x < 6; x++){
    if (x == 5){
      colors[x] = old[0];
      
    } else {
      colors[x] = old[x+1]; 
    }
  }
}

void moving_rainbow(){
  move_colors();
  for (int x = 0; x < NUM_LEDS; x++){
    leds[x] = colors[x%6];
    delay(1);
  }

  FastLED.show(); 
}
