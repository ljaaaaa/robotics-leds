// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class InfoManagerSubsystem extends SubsystemBase {
  
  private SerialPort arduino;

  public InfoManagerSubsystem() throws Exception {

    //Connect ot one of three different USB ports
    try {
      arduino = new SerialPort(9600, SerialPort.Port.kUSB);
      System.out.println("---------Connected on kUSB---------");
    } catch (Exception e) {

      try {
        arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
        System.out.println("---------Connected on kUSB1---------");
      } catch (Exception e1) {

        try {
          arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
          System.out.println("---------Connected on kUSB2---------");
        } catch (Exception e2) {
          throw new Exception("Failed to connect to USB Ports");
        }
      }
    }
  }

  public void sendMessage(byte[] info){
      arduino.write(info, 1);
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    
  }
}