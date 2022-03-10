// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LEDPatterns;
import frc.robot.MyColor;

public class LEDSubsytem extends SubsystemBase {
  //Global variables
  AddressableLEDBuffer buffer;
  AddressableLED led;

  public MyColor[] rainbow = Constants.rainbow_colors;

  public LEDPatterns patterns;

  //Constructor
  public LEDSubsytem() {
    led = new AddressableLED(0);
    buffer = new AddressableLEDBuffer(1);
  
    patterns = new LEDPatterns(buffer, led);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);

    led.start();

    patterns.setColor(10, Constants.blue);
    patterns.setData();
  }

  public void paintRed(){
    for (int x = 0; x < buffer.getLength(); x++){
      setColor(x, Constants.blue);
      setData();
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