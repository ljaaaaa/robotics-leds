// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.MyColor;
import frc.robot.subsystems.LEDSubsytem;

public class SolidCommand extends CommandBase {
  
  public LEDSubsytem system;
  public Supplier<Boolean> getButton;

  MyColor[] array = Constants.rainbow_colors;

  int pos = 1;

  public SolidCommand(LEDSubsytem system, Supplier<Boolean> getButton) {
    this.system = system;
    addRequirements(system);
    this.getButton = getButton;
  }

  @Override
  public void initialize() {
      //system.StrangePattern();
  } 

  @Override
  public void execute() {
     //system.StrangePattern();
     //system.moveSingleBlock(color);
      system.movingRainbow(array);

      try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        
    }

  @Override
  public void end(boolean interrupted) {
      system.stop();
  }
  
  @Override
  public boolean isFinished() {
    return getButton.get(); 
  }
}