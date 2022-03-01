// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;

public class MyLEDBuffer extends AddressableLEDBuffer {
  public byte[] m_buffer;

  public MyLEDBuffer(int length) {
      super(length);
      m_buffer = new byte[length * 5];
  }

  @Override
  @SuppressWarnings("ParameterName")
  public void setRGB(int index, int r, int g, int b) {
    System.out.println("setting rgb");
    System.out.println(m_buffer);
    m_buffer[index * 5] = (byte) b;
    m_buffer[(index * 5) + 1] = (byte) g;
    m_buffer[(index * 5) + 2] = (byte) r;
    m_buffer[(index * 5) + 3] = 0; //white
    m_buffer[(index * 5) + 3] = 0;
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
    return m_buffer.length / 5;
  }

  @Override
  public Color8Bit getLED8Bit(int index) {
    return new Color8Bit(
        m_buffer[index * 5 + 2] & 0xFF, m_buffer[index * 5 + 1] & 0xFF, m_buffer[index * 5] & 0xFF);
  }

  @Override
  public Color getLED(int index) {
    return new Color(
        (m_buffer[index * 5 + 2] & 0xFF) / 255.0,
        (m_buffer[index * 5 + 1] & 0xFF) / 255.0,
        (m_buffer[index * 5] & 0xFF) / 255.0);
  }
}