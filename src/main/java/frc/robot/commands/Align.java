/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Aligner;
import frc.robot.Camera;
import frc.robot.Robot;

public class Align extends Command {
  private PIDController pidAlign;
  private long start;

  public Align() {
    requires(Robot.drivetrain);
    Camera camera = new Camera();
    camera.setPIDSourceType(PIDSourceType.kDisplacement);
    Aligner aligner = new Aligner();
    pidAlign = new PIDController(0.05, 0, 0, camera, aligner);
    pidAlign.enable();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    start = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println(pidAlign.get());
    Robot.drivetrain.drive(-pidAlign.get(), 0, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return System.currentTimeMillis() - start > 2000;
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
