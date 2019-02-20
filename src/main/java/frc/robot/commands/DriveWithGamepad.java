/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveWithGamepad extends Command {
  public DriveWithGamepad() {
    requires(Robot.drivetrain);
    requires(Robot.positionTracker);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drivetrain.drive(
      Robot.oi.controllerDriver.getRawAxis(RobotMap.PORT_AXIS_LJX),
      Robot.oi.controllerDriver.getRawAxis(RobotMap.PORT_AXIS_LJY),
      Robot.oi.controllerDriver.getRawAxis(RobotMap.PORT_AXIS_RJX),
      Robot.positionTracker.getAngle()
    );
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
