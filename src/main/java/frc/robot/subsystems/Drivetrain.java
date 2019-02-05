/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithGamepad;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // WPI_VictorSPX motorFrontRight = new WPI_VictorSPX(RobotMap.MOTOR_PORT_FRONT_RIGHT);
  // WPI_VictorSPX motorRearRight = new WPI_VictorSPX(RobotMap.MOTOR_PORT_REAR_RIGHT);
  // WPI_VictorSPX motorFrontLeft = new WPI_VictorSPX(RobotMap.MOTOR_PORT_FRONT_LEFT);
  // WPI_VictorSPX motorRearLeft = new WPI_VictorSPX(RobotMap.MOTOR_PORT_REAR_LEFT);
  
  public double speedModifier;
  MecanumDrive mecanumDrive;

  public Drivetrain(){
    final WPI_TalonSRX motorFrontRight = new WPI_TalonSRX(RobotMap.MOTOR_PORT_FRONT_RIGHT);
    final WPI_TalonSRX motorRearRight = new WPI_TalonSRX(RobotMap.MOTOR_PORT_REAR_RIGHT);
    final WPI_TalonSRX motorFrontLeft = new WPI_TalonSRX(RobotMap.MOTOR_PORT_FRONT_LEFT);
    final WPI_TalonSRX motorRearLeft = new WPI_TalonSRX(RobotMap.MOTOR_PORT_REAR_LEFT);

    mecanumDrive = new MecanumDrive(motorFrontRight, motorRearRight, motorFrontLeft, motorRearLeft);
    speedModifier = 1;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithGamepad());
  }

  public void drive(double y, double x, double z) {
    mecanumDrive.driveCartesian(y, x, z);
  }
}
