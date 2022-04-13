void mvrt_pattern(){
   for (int x = 0; x < NUM_LEDS; x++){
    if (x%2 == 0){
      leds[x] = CRGB(0xFFC410); //Gold
    } else {
      leds[x] = CRGB(0x260235); //Purple
    }
  }
}
