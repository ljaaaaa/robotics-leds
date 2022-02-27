// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.MyColor;
import frc.robot.MyLEDBuffer;

public class LEDSubsytem extends SubsystemBase {
  //Global variables
  public AddressableLED led;
  public AddressableLEDBuffer buffer2;
  public MyLEDBuffer buffer;
//  public AddressableLEDBuffer buffer;

  public MyColor[] rainbow = Constants.rainbow_colors;

  //For moving block
  int position = 0;
  boolean goingUp = true;;

  //Constructor
  public LEDSubsytem() {
    led = new AddressableLED(0);
    buffer = new MyLEDBuffer(30);
  //  buffer = new AddressableLEDBuffer(30);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);

    led.start();

    setColor(0, Constants.blue);
    setData();
  }

  public void paintRed(){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, Constants.blue);
      setData();
    }
  }

  public void movingRainbow(MyColor[] array){
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

  public void moveBlock(MyColor color){
    if (position == buffer.getLength()-1){
        goingUp = false;

    } else if (position == 0){
        goingUp = true;
    }

    if (goingUp){
        position++;
        setColor(position, color);

    } else {
        position--;
        setColor(position, Constants.black);
    }
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

  //Make a still MVRT (purple/gold) pattern
  public void MVRTPattern(){
    for (int x = 0; x < buffer.getLength(); x++){
        if (x%2 == 0){ //set to purple
            setColor(x, Constants.mvrtPurple);
        
          } else { //set to gold
            setColor(x, Constants.mvrtGold);
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
<<<<<<< HEAD:src/main/java/frc/robot/subsystems/LEDSubsytem.java
=======
      
>>>>>>> c3350d1544f902c82736e708087996b6ed15f694:RobotJava/src/main/java/frc/robot/subsystems/LEDSubsytem.java
  }
}