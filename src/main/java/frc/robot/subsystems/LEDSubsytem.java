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
    buffer = new AddressableLEDBuffer(60);
    
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

  //Moving rainbow pattern
  public void movePattern(MyColor[] array){

    //Move each color in array by one index
    for (int x = 0; x < array.length; x++){
      
      if (x > 0){ //Move backwards - give next color of array
        array[x] = array[x-1]; 

      } else { //Loop back and get last color of array
        array[x] = array[array.length-1];
      }

      //Set color for LED
      setColor(x, array[x]);
    }
  }

  //Make a still MVRT (red/gold) pattern
  public void MVRTPattern(){
    MyColor color1 = Constants.mvrtPurple;
    MyColor color2 = Constants.mvrtGold;

    for (int x = 0; x < buffer.getLength(); x++){
        if (x%2 == 0){ //set to color 1
            setColor(x, color1);
        
          } else if (x%2 == 1){ //set to color 2
            setColor(x, color2);
        }
    }
  }
 
  //Sets color of one square
  private void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
    setData();
  }

  public void setData(){
    led.setData(buffer);
  }

  @Override
  public void periodic() {

  }
}