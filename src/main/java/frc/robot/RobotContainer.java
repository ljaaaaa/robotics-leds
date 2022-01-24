// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.SolidCommand;
import frc.robot.subsystems.LEDSubsytem;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  
  private final LEDSubsytem subsystem = new LEDSubsytem();
  private final SolidCommand command = new SolidCommand(subsystem);

  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
