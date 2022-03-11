// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.PatternCommand;
import frc.robot.subsystems.LEDSubsytem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  
  private final LEDSubsytem subsystem = new LEDSubsytem();
  private Joystick joystick;
  private JoystickButton buttonA;

  public RobotContainer() {
    joystick = new Joystick(0);
    buttonA = new JoystickButton(joystick, 1);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
      buttonA.whenPressed(new PatternCommand(subsystem, this::getSolidButton));   
  }

  public Command getAutonomousCommand() {
    return null;
  }

  public boolean getSolidButton(){
    return buttonA.get();
  }
}