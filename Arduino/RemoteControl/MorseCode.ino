CRGB MyPurple = CRGB(0x7500ff);
//int pos;

int ARR_LEN = 30;
CRGB morse_colors[] {
  //M
  MyPurple, MyPurple, CRGB::Black, MyPurple, MyPurple,

  //Space
  CRGB::Black, CRGB::Black, CRGB::Black,

  //V
  MyPurple, CRGB::Black, MyPurple, CRGB::Black, MyPurple, CRGB::Black, MyPurple, MyPurple,

  //Space
  CRGB::Black, CRGB::Black, CRGB::Black,

  //R
  MyPurple, CRGB::Black, MyPurple, MyPurple, CRGB::Black, MyPurple,

  //Space
  CRGB::Black, CRGB::Black, CRGB::Black,

  //T
  MyPurple, MyPurple
};

//Spell MVRT in morse code and have it glide across leds
void morse_code(){
  move_morse_colors

  

  for (int x = 0; x < sizeof(morse_colors)/sizeof(CRGB); x++){
    leds[x] = morse_colors[x];
  }
    
  FastLED.show();
}

void move_morse_colors(){
  CRGB old[300] = morse_colors;
  
  for (int x = 0; x < 30; x++){
    if (x == 29){
      morse_colors[x] = old[0];
      
    } else {
      morse_colors[x] = old[x+1]; 
    }
  }
}
