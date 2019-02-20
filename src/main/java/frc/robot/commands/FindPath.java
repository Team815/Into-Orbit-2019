/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Sensors;

public class FindPath extends Command {

  private int x = 100;
  private int y = 100;
  private int encHorzPrev = 0;
  private int encVertPrev = 0;
  private double anglePrev = 0;
  private NetworkTableEntry nteX;
  private NetworkTableEntry nteY;
  private NetworkTableEntry nteZ;

  public FindPath() {
    requires(Robot.positionTracker);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("position");
    nteX = table.getEntry("x");
    nteY = table.getEntry("y");
    nteZ = table.getEntry("z");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int encHorz = Robot.positionTracker.getHorizontal();
    int encVert = Robot.positionTracker.getVertical();
    int horzDiff = encHorz - encHorzPrev;
    int vertDiff = encVert - encVertPrev;
    double angleDeg = Sensors.gyro.getAngle();
    double angle = Math.toRadians(angleDeg);
    double angleAve = (angle + anglePrev) / 2;
    x += vertDiff * Math.cos(angleAve) - horzDiff * Math.sin(angleAve);
    y -= horzDiff * Math.cos(angleAve) + vertDiff * Math.sin(angleAve);
    //System.out.println("H: " + encHorz + ", V: " + encVert + ", A: " + Robot.positionTracker.getAngle());
    //System.out.println("HD: " + horzDiff + ", VD: " + vertDiff + ", A: " + angleDeg);
    //System.out.println("X: " + x + ", Y: " + y + ", A: " + angleAve);
    nteX.setNumber(x/20);
    nteY.setNumber(y/20);
    nteZ.setNumber(-angleDeg);
    encHorzPrev = encHorz;
    encVertPrev = encVert;
    anglePrev = angle;
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
