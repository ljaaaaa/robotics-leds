// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LEDPatterns;
import frc.robot.MyColor;

public class LEDSubsytem extends SubsystemBase {
  AddressableLEDBuffer buffer;
  AddressableLED led;

  public LEDPatterns patterns;

  //Constructor
  public LEDSubsytem() {
    led = new AddressableLED(0);
    buffer = new AddressableLEDBuffer(120);
    patterns = new LEDPatterns(buffer, led);

    led.setLength(buffer.getLength());
    led.setData(buffer);
    led.start();

    patterns.faded_rainbow();
    setData();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  //Sets color of one square
  public void setColor(int index, MyColor color){
    buffer.setRGB(index, color.red, color.green, color.blue);
    setData();
  }

  //Update led data from buffer
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