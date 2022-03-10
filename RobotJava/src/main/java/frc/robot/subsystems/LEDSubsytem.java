// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
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
    buffer = new AddressableLEDBuffer(10);
    
    led.setLength(buffer.getLength());
    led.setData(buffer);
    led.start();

    //setColor(0, new MyColor(0, 0, 0));
    //setColor(1, new MyColor(0, 0, 0));

   // setColor(0, Constants.red);
    buffer.setLED(0, new Color(0, 0, 255));
    led.setData(buffer);
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(0));
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(0).red);
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(0).green);
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(0).blue);

    System.out.println("----");
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(1));
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(1).red);
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(1).green);
    System.out.println("!!!!!!!!!!!!!!!!!!!!!! - " + buffer.getLED(1).blue);
    System.out.println("hello");


    //setColor(1, new MyColor(0, 0, 0));
    led.setData(buffer);
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