void setup() {
    Serial.begin(9600);
}

void loop() {
  if (Serial.available()){
    byte value = Serial.read();

    if (value == 0x12){
      Serial.print("Received information from roborio!"); 
    }
  }
}
