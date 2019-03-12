/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Latch;

public class ToggleLatch extends Command {

  private double TIMEOUT = 1;
  private Timer timer;

  public ToggleLatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.latch);
    timer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.latch.isLocked()){
      Robot.latch.unlock();
    }
    else {
      Robot.latch.lock();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (
        Robot.latch.getEncoder() >= Latch.ENCODER_MAX_VALUE 
        || Robot.latch.getEncoder() <= Latch.ENCODER_MIN_VALUE
        || timer.get() >= TIMEOUT
      ) 
      {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.latch.stop();
    timer.stop();
    timer.reset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    timer.stop();
    timer.reset();
  }
}
