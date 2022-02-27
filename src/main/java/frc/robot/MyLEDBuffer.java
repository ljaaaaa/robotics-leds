// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.util.Color8Bit;

/** Buffer storage for Addressable LEDs. */
public class MyLEDBuffer extends AddressableLEDBuffer {
  //byte[] m_buffer;

  public MyLEDBuffer(int length) {
      super(length);
    //m_buffer = new byte[length * 4];
  }

  /*
   @SuppressWarnings("ParameterName")
  public void setRGB(int index, int r, int g, int b) {
    m_buffer[index * 4] = (byte) b;
    m_buffer[(index * 4) + 1] = (byte) g;
    m_buffer[(index * 4) + 2] = (byte) r;
    m_buffer[(index * 4) + 3] = 0;
  }

  @SuppressWarnings("ParameterName")
  public void setHSV(final int index, final int h, final int s, final int v) {
    if (s == 0) {
      setRGB(index, v, v, v);
      return;
    }

    final int region = h / 30;
    final int remainder = (h - (region * 30)) * 6;

    final int p = (v * (255 - s)) >> 8;
    final int q = (v * (255 - ((s * remainder) >> 8))) >> 8;
    final int t = (v * (255 - ((s * (255 - remainder)) >> 8))) >> 8;

    switch (region) {
      case 0:
        setRGB(index, v, t, p);
        break;
      case 1:
        setRGB(index, q, v, p);
        break;
      case 2:
        setRGB(index, p, v, t);
        break;
      case 3:
        setRGB(index, p, q, v);
        break;
      case 4:
        setRGB(index, t, p, v);
        break;
      default:
        setRGB(index, v, p, q);
        break;
    }
  }

  public void setLED(int index, Color color) {
    setRGB(index, (int) (color.red * 255), (int) (color.green * 255), (int) (color.blue * 255));
  }

  public void setLED(int index, Color8Bit color) {
    setRGB(index, color.red, color.green, color.blue);
  }

  public int getLength() {
    return m_buffer.length / 4;
  }

  public Color8Bit getLED8Bit(int index) {
    return new Color8Bit(
        m_buffer[index * 4 + 2] & 0xFF, m_buffer[index * 4 + 1] & 0xFF, m_buffer[index * 4] & 0xFF);
  }

  public Color getLED(int index) {
    return new Color(
        (m_buffer[index * 4 + 2] & 0xFF) / 255.0,
        (m_buffer[index * 4 + 1] & 0xFF) / 255.0,
        (m_buffer[index * 4] & 0xFF) / 255.0);
  }
  */
}
