// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class MyLEDBuffer extends AddressableLEDBuffer {
  public byte[] buffer;

  public MyLEDBuffer(int length) {
      super(length);
      buffer = new byte[length * 5];
  }

  @Override
  @SuppressWarnings("ParameterName")
  public void setRGB(int index, int r, int g, int b) {
    buffer[index * 5] = (byte) b;
    buffer[(index * 5) + 1] = (byte) g;
    buffer[(index * 5) + 2] = (byte) r;
    buffer[(index * 5) + 3] = 0; //white
    buffer[(index * 5) + 3] = 0;
  }

  @Override
  public void setLED(int index, Color color) {
    setRGB(index, (int) (color.red * 255), (int) (color.green * 255), (int) (color.blue * 255));
  }

  @Override
  public void setLED(int index, Color8Bit color) {
    setRGB(index, color.red, color.green, color.blue);
  }

  @Override
  public int getLength() {
    return buffer.length / 5;
  }

  @Override
  public Color8Bit getLED8Bit(int index) {
    return new Color8Bit(
        buffer[index * 5 + 2] & 0xFF, buffer[index * 5 + 1] & 0xFF, buffer[index * 5] & 0xFF);
  }

  @Override
  public Color getLED(int index) {
    return new Color(
        (buffer[index * 5 + 2] & 0xFF) / 255.0,
        (buffer[index * 5 + 1] & 0xFF) / 255.0,
        (buffer[index * 5] & 0xFF) / 255.0);
  }
}