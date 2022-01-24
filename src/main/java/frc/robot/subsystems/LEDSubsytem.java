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

  public AddressableLED led;
  public AddressableLEDBuffer buffer;

  public MyColor[] movableColors = Constants.rainbow_colors;

  public LEDSubsytem() {
    //Entire LED Strip
    led = new AddressableLED(0);
    buffer = new AddressableLEDBuffer(60);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);
  }

  public void moveRainbow(){

    //Move positions by moving color orders around
    MyColor[] colors = Constants.rainbow_colors;

    for (int x = 0; x < buffer.getLength(); x++){
      
      MyColor color = colors[x%colors.length];




      led.setData(buffer);
    }
  }

  public void MVRTPattern(){
    MyColor color1 = Constants.mvrtPurple;
    MyColor color2 = Constants.mvrtGold;

    for (int x = 0; x < buffer.getLength(); x++){
        if (x%2 == 0){ //set to color 1
            setColor(x, color1);
        
          } else if (x%2 == 1){ //set to color 2
            setColor(x, color2);
        }
        led.setData(buffer);
    }
  }

  public void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
  }

  @Override
  public void periodic() {

  }
}