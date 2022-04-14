CRGB MyPurple = CRGB(0x7500ff);
//int pos;

int ARR_LEN = 30;
CRGB morse_colors[] {
  /*M*/MyPurple, MyPurple, CRGB::Black, MyPurple, MyPurple,

  /*Space */CRGB::Black, CRGB::Black, CRGB::Black,

  /*V*/MyPurple, CRGB::Black, MyPurple, CRGB::Black, MyPurple, CRGB::Black, MyPurple, MyPurple,

  /*Space*/ CRGB::Black, CRGB::Black, CRGB::Black,

  /*R*/MyPurple, CRGB::Black, MyPurple, MyPurple, CRGB::Black, MyPurple,

  /*Space*/CRGB::Black, CRGB::Black, CRGB::Black,

  /*T*/MyPurple, MyPurple
};

//Spell MVRT in morse code
void morse_code(){
  for (int x = 0; x < ARR_LEN; x++){
    leds[x] = morse_colors[x];
  }
}
