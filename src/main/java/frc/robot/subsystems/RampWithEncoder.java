/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import frc.robot.commands.MoveRamp;

public class RampWithEncoder extends Ramp {

  private Encoder encoder;
  private PIDController pid;

  public RampWithEncoder(int portMotorLeft, int portMotorRight, int inputPort, int[] encoderPorts) {
    super(portMotorLeft, portMotorRight, inputPort);
    encoder = new Encoder(encoderPorts[0], encoderPorts[1]);
    pid = new PIDController(0.01, 0, 0, encoder, motors);
    pid.setSetpoint(encoder.get());
    pid.setOutputRange(-0.2, 0.2);
    pid.enable();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveRamp(this, inputPort));
  }

  @Override
  public void move(double speed) {
    System.out.println(encoder.get() + ", " + pid.get());
    speed = Math.abs(speed) < 0.1 ? 0 : speed;
    motors.set(speed);
  }
}
