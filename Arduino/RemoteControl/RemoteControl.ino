#include "IRremote.h"
#include "SR04.h"

#define TRIG_PIN 13
#define ECHO_PIN 12
#define RECEIVER_PIN 11

IRrecv irrecv(RECEIVER_PIN);
decode_results results;

void setup(){
  Serial.begin(9600);
  Serial.println("Receiving Now"); 
  
  irrecv.enableIRIn(); // Start the receiver
}


void loop(){
  //Signal received
  if (irrecv.decode(&results)){
    translateIR(); 
    irrecv.resume(); // receive the next value
  }  
}

void translateIR() {
  switch(results.value) {
    case 0xFF6897: 
      Serial.println("0");   
      break;
    case 0xFF30CF: 
      Serial.println("1");    
      break;
    case 0xFF18E7: 
      Serial.println("2");    
      break;
    case 0xFF7A85: Serial.println("3");    break;
    case 0xFF10EF: Serial.println("4");    break;
    case 0xFF38C7: Serial.println("5");    break;
    case 0xFF5AA5: Serial.println("6");    break;
    case 0xFF42BD: Serial.println("7");    break;
    case 0xFF4AB5: Serial.println("8");    break;
    case 0xFF52AD: Serial.println("9");    break;
    case 0xFFFFFFFF: Serial.println(" REPEAT");break;  
    default: Serial.println(" other button   ");
  }
  delay(500); // Do not get immediate repeat
}
