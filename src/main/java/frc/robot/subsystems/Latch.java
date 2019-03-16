/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Latch extends PIDSubsystem {

  SpeedController motor = new WPI_TalonSRX(RobotMap.PORT_MOTOR_LATCH);
  Encoder encoder = new Encoder(RobotMap.PORT_ENCODER_LATCH[0], RobotMap.PORT_ENCODER_LATCH[1]);
  double output;

  public Latch() {
    super(0.01, 0, 0);
    enable();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    setOutputRange(-0.4, 0.4);
    return encoder.get();
  }

  @Override
  protected void usePIDOutput(double output) {
    System.out.println("In: " + encoder.get() + ", Out: " + output);
    this.output = output;
    motor.set(output);
  }

  public void open() {
    setSetpoint(70);
  }
}
