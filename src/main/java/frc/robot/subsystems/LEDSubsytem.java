// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MyColor;

public class LEDSubsytem extends SubsystemBase {
  //Global variables
  public AddressableLED led;
  public AddressableLEDBuffer buffer;

  //Constructor
  public LEDSubsytem() {
    led = new AddressableLED(0);
    buffer = new AddressableLEDBuffer(120);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);

    led.start();
  }
  //Set entire strip to one color
  public void setBaseColor(MyColor color){

    for (int x = 0; x < buffer.getLength(); x++){
      //Set color for LED
      setColor(x, color);
    }
  }

  public void StrangePattern() {
    MyColor beautifulPurple = new MyColor(100, 6, 158);
    MyColor coolGold = new MyColor(255, 213, 0);
    int l = 0;
    while(l <= 100){
      for(int j =0; j<100; j++){
        for(int lol = 0; lol<buffer.getLength(); lol++){
          if(lol%3 == 0){
            setColor(lol+j, beautifulPurple);
          } else if(lol%3 == 1){
            setColor(lol+j, coolGold);
          } else if(lol%3 == 2){
            setColor(lol+j, beautifulPurple);
          }
        }

        l++;
      }
    }
  }

  public void movingRainbow(MyColor[] array){
    MyColor[] old_array = array;
    MyColor[] new_array = array;

        //Move each color in array by one index
        for (int x = 0; x < array.length; x++){
          if (x < array.length-1){ //Move backwards - give next color of array
            new_array[x] = array[x+1]; 

          } else { //Loop back and get last color of array
            new_array[x] = array[0];
          }
        }
        array = new_array;

        //Print array with new pattern
        paintArray(array);
        setData();
  }

  //Move single block
  public void moveSingleBlock(MyColor color){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, color);
    
      if (x-1 == -1){
        setColor(buffer.getLength()-1, Constants.black);
      } else {
        setColor(x-1, Constants.black);
      }

      setData();

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  //Paints whatever pattern an array has
  public void paintArray(MyColor[] array){
    for (int x = 0; x < buffer.getLength(); x++){
      //Set color for LED
      setColor(x, array[x%array.length]);
      setData();
    }
  }

  //Make a still MVRT (red/gold) pattern
  public void MVRTPattern(){
    MyColor color1 = Constants.blue;
    MyColor color2 = Constants.red;

    for (int x = 0; x < buffer.getLength(); x++){
        if (x%2 == 0){ //set to color 1
            setColor(x, color1);
        
          } else { //set to color 2
            setColor(x, color2);
        }
    }
  }
 
  //Sets color of one square
  public void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
    setData();
  }

  public void setData(){
    led.setData(buffer);
  }

  public void stop(){
    led.stop();
  }

  @Override
  public void periodic() {

  }
}