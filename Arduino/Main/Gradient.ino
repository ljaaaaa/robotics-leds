void gradient(CRGB color1, CRGB color2){
  int changeInRed = (color2.r - color1.r)/(NUM_LEDS-1);
  int changeInGreen = (color2.g - color1.g)/(NUM_LEDS-1);
  int changeInBlue = (color2.b - color1.b)/(NUM_LEDS-1);

  Serial.println("\ncolor1");
  Serial.print(color1.r);
  Serial.print(", ");
  Serial.print(color1.g);
  Serial.print(", ");
  Serial.print(color1.b);

  Serial.println("\ncolor2");
  Serial.print(color2.r);
  Serial.print(", ");
  Serial.print(color2.g);
  Serial.print(", ");
  Serial.print(color2.b);
  

  Serial.println("\nchanges");
  Serial.println(changeInRed);
  Serial.println(changeInGreen);
  Serial.println(changeInBlue);

  for (int x = 0; x < NUM_LEDS; x++){
     leds[x].r = color1.r + changeInRed*x;
     leds[x].g = color1.g + changeInGreen*x;
     leds[x].b = color1.b + changeInBlue*x;
     Serial.print(x);
     Serial.print(": ");
     Serial.print(leds[x].r);
     Serial.print(", ");
     Serial.print(leds[x].g);
     Serial.print(", ");
     Serial.print(leds[x].b);
     Serial.println();
  }
  FastLED.show();
}
