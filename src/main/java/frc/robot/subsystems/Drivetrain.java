/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.RobotMap;
import frc.robot.Sensors;
import frc.robot.commands.DriveWithGamepad;

public class Drivetrain extends PIDSubsystem {

  public final double SPEED_MODIFIER_MIN = 0.2;
  public final double SPEED_MODIFIER_MAX = 1;
  
  public double speedModifier;
  private double correction = 0;
  private double angleOffset = 0;
  private MecanumDrive mecanumDrive;
  private Gyro gyro;

  public Drivetrain(){
    super(0.01, 0, 0);
    final CANSparkMax motorFrontLeft = new CANSparkMax(RobotMap.PORT_MOTOR_DRIVE_FRONT_LEFT, MotorType.kBrushless);
    final CANSparkMax motorFrontRight = new CANSparkMax(RobotMap.PORT_MOTOR_DRIVE_FRONT_RIGHT, MotorType.kBrushless);
    final CANSparkMax motorRearLeft = new CANSparkMax(RobotMap.PORT_MOTOR_DRIVE_REAR_LEFT, MotorType.kBrushless);
    final CANSparkMax motorRearRight = new CANSparkMax(RobotMap.PORT_MOTOR_DRIVE_REAR_RIGHT, MotorType.kBrushless);
    mecanumDrive = new MecanumDrive(motorFrontRight, motorRearRight, motorFrontLeft, motorRearLeft);

    gyro = Sensors.gyro;
    setSetpoint(gyro.getAngle());
    enable();
    speedModifier = 1;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveWithGamepad());
  }

  public void drive(double y, double x, double z) {
    y = Math.abs(y) < 0.1 ? 0 : y;
    x = Math.abs(x) < 0.1 ? 0 : x;
    z = Math.abs(z) < 0.1 ? 0 : z;
    x *= speedModifier;
    y *= speedModifier;
    z *= speedModifier;
    double currentAngle = gyro.getAngle();

    if (z == 0) {
      z = correction;
    } else {
      setSetpoint(currentAngle);
    }

    mecanumDrive.driveCartesian(-y, -x, z, currentAngle - angleOffset);
  }

  public void driveRaw(double y, double x, double z) {
    y = Math.abs(y) < 0.1 ? 0 : y;
    x = Math.abs(x) < 0.1 ? 0 : x;
    z = Math.abs(z) < 0.1 ? 0 : z;
    x *= speedModifier;
    y *= speedModifier;
    z *= speedModifier;
    mecanumDrive.driveCartesian(-y, -x, z);
  }

  public void resetPlayerAngle() {
    angleOffset = gyro.getAngle();
    setSetpoint(gyro.getAngle());
  }

  @Override
  protected double returnPIDInput() {
    return gyro.getAngle();
  }

  @Override
  protected void usePIDOutput(double output) {
    correction = output;
  }
}
