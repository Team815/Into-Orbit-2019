/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotMap;
import frc.robot.commands.FindPath;

public class PositionTracker extends Subsystem {
  
  private Encoder omniHorizontal = new Encoder(RobotMap.PORT_ENCODER_DRIVE_HORIZONTAL[0], RobotMap.PORT_ENCODER_DRIVE_HORIZONTAL[1]);
  private Encoder omniVertical = new Encoder(RobotMap.PORT_ENCODER_DRIVE_VERTICAL[0], RobotMap.PORT_ENCODER_DRIVE_VERTICAL[1]);
  
  private Gyro gyro = new AnalogGyro(0);


  public PositionTracker() {
    omniHorizontal.setReverseDirection(true);
    omniVertical.setReverseDirection(true);
    gyro.calibrate();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new FindPath());
  }

  public int getHorizontal() {
    return omniHorizontal.get();
  }

  public int getVertical() {
    return omniVertical.get();
  }

  public double getAngle() {
    return gyro.getAngle();
  }

  public void resetGyro() {
    gyro.reset();
  }
}
