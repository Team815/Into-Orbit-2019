/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // WPI_VictorSPX motorFrontRight = new WPI_VictorSPX(RobotMap.MOTOR_PORT_FRONT_RIGHT);
	// WPI_VictorSPX motorRearRight = new WPI_VictorSPX(RobotMap.MOTOR_PORT_REAR_RIGHT);
	// WPI_VictorSPX motorFrontLeft = new WPI_VictorSPX(RobotMap.MOTOR_PORT_FRONT_LEFT);
  // WPI_VictorSPX motorRearLeft = new WPI_VictorSPX(RobotMap.MOTOR_PORT_REAR_LEFT);
  MecanumDrive mecanumDrive;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void drive(double y, double x, double z) {
    mecanumDrive.driveCartesian(y, x, z);
  }



}
