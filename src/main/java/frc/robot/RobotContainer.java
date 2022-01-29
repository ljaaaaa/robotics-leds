// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.SolidCommand;
import frc.robot.subsystems.LEDSubsytem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  private final LEDSubsytem subsystem = new LEDSubsytem();
  private Joystick stick;
  private JoystickButton solidButton;

  public RobotContainer() {
    stick = new Joystick(0);
    solidButton = new JoystickButton(stick, 1);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
      solidButton.whenPressed(new SolidCommand(subsystem, this::getSolidButton));
      
  }

  public Command getAutonomousCommand() {
    return null;
  }

  public boolean getSolidButton(){
    return solidButton.get();
  }
}
