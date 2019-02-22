/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveRampRear;

public class RampRear extends PIDSubsystem {

  private SpeedControllerGroup motors;
  private Encoder encoder;
  
  public RampRear() {
    super(0.01, 0, 0);
    WPI_TalonSRX motorLeft = new WPI_TalonSRX(RobotMap.PORT_MOTOR_RAMP_REAR_LEFT);
    WPI_TalonSRX motorRight = new WPI_TalonSRX(RobotMap.PORT_MOTOR_RAMP_REAR_RIGHT);
    motorRight.setInverted(true);
    motors = new SpeedControllerGroup(motorLeft, motorRight);
    encoder = new Encoder(RobotMap.PORT_ENCODER_RAMP_REAR_RIGHT[0], RobotMap.PORT_ENCODER_RAMP_REAR_RIGHT[1]);
    setSetpoint(encoder.getRaw());
    enable();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveRampRear());
  }

  public void move(double movement) {
    movement = Math.abs(movement) < 0.1 ? 0 : movement;
    setSetpoint(getSetpoint() + movement * 3);
    System.out.println("Enc: " + encoder.getRaw() + ", Set: " + getSetpoint());
  }

  @Override
  protected double returnPIDInput() {
    return encoder.getRaw();
  }

  @Override
  protected void usePIDOutput(double output) {
    if (encoder.getRaw() >= 0 || output < 0) {
      motors.set(output);
    }
  }
}
