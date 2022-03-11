// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.SendInformationCommand;
import frc.robot.subsystems.InfoManagerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

public class RobotContainer {

  private InfoManagerSubsystem infoManager;
  private Joystick joystick;
  private JoystickButton buttonA;
  private JoystickButton buttonB;

  public RobotContainer() {
    try {
      infoManager = new InfoManagerSubsystem();
    } catch (Exception e){ //Cannot connect to USB
      e.printStackTrace();
    }

    joystick = new Joystick(0);
    buttonA = new JoystickButton(joystick, 1);
    buttonB = new JoystickButton(joystick, 2);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    buttonA.whenPressed(new SendInformationCommand(infoManager, Constants.info1));
    buttonB.whenPressed(new SendInformationCommand(infoManager, Constants.info2));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}