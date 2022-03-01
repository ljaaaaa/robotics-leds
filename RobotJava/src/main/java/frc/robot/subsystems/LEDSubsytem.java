// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LEDPatterns;
import frc.robot.MyColor;
import frc.robot.MyLED;
import frc.robot.MyLEDBuffer;

public class LEDSubsytem extends SubsystemBase {
  //Global variables
  public MyLED led;

  public AddressableLEDBuffer buffer2;
  public MyLEDBuffer buffer;

  public MyColor[] rainbow = Constants.rainbow_colors;

  public LEDPatterns patterns;

  //Constructor
  public LEDSubsytem() {
    System.out.println("testy");
    led = new MyLED(0);
    buffer = new MyLEDBuffer(30);
  
    patterns = new LEDPatterns(buffer, led);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);

    led.start();

    patterns.setColor(10, Constants.blue);
    patterns.setData();
  }

  public void stop(){
    led.stop();
  }

  @Override
  public void periodic() {
    
  }
}