// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.AddressableLEDJNI;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.PWMJNI;

public class MyLED extends AddressableLED {
 // private final int m_pwmHandle;
 // private final int m_handle;

  public MyLED(int port) {
    super(port);
 //   m_pwmHandle = PWMJNI.initializePWMPort(HAL.getPort((byte) port));
 //   m_handle = AddressableLEDJNI.initialize(m_pwmHandle);
 //   HAL.report(tResourceType.kResourceType_AddressableLEDs, port + 1);
  }
/*

  @Override
  public void close() {
    if (m_handle != 0) {
      AddressableLEDJNI.free(m_handle);
    }
    if (m_pwmHandle != 0) {
      PWMJNI.freePWMPort(m_pwmHandle);
    }
  }

  public void setLength(int length) {
    AddressableLEDJNI.setLength(m_handle, length);
  }

  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  public void setData(MyLEDBuffer buffer) {
    AddressableLEDJNI.setData(m_handle, buffer.buffer);
  }

  public void setBitTiming(
      int lowTime0NanoSeconds,
      int highTime0NanoSeconds,
      int lowTime1NanoSeconds,
      int highTime1NanoSeconds) {
    AddressableLEDJNI.setBitTiming(
        m_handle,
        lowTime0NanoSeconds,
        highTime0NanoSeconds,
        lowTime1NanoSeconds,
        highTime1NanoSeconds);
  }

  public void setSyncTime(int syncTimeMicroSeconds) {
    AddressableLEDJNI.setSyncTime(m_handle, syncTimeMicroSeconds);
  }

  public void start() {
    AddressableLEDJNI.start(m_handle);
  }

  public void stop() {
    AddressableLEDJNI.stop(m_handle);
  }
  */
}
