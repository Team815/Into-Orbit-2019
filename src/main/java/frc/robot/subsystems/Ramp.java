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
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveRamp;

/**
 * Add your docs here.
 */
public class Ramp extends Subsystem {

  SpeedControllerGroup motors;
  Encoder encoderRight;
  Encoder encoderLeft;
  private int encoderMaxValue;
  private int inputPort;

  public Ramp (int portMotorLeft, int portMotorRight, int inputPort) {
    WPI_TalonSRX motorLeft = new WPI_TalonSRX(portMotorLeft);
    WPI_TalonSRX motorRight = new WPI_TalonSRX(portMotorRight);
    motorRight.setInverted(true);
    motors = new SpeedControllerGroup(motorLeft, motorRight);
    this.inputPort = inputPort;
    encoderRight = new Encoder(
      RobotMap.ENCODER_PORT_REAR_RAMP_RIGHT[0], 
      RobotMap.ENCODER_PORT_REAR_RAMP_RIGHT[1]
    );

    encoderLeft = new Encoder(
      RobotMap.ENCODER_PORT_REAR_RAMP_LEFT[0], 
      RobotMap.ENCODER_PORT_REAR_RAMP_LEFT[1]
    );
    encoderMaxValue = 1000;

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveRamp(this, inputPort));
  }

public void move(double speed) {
  speed = Math.abs(speed) < 0.1 ? 0 : speed;
  motors.set(speed);
}

public void lowerRamp() {
  while(encoderLeft.get() < encoderMaxValue ||
   encoderRight.get() < encoderMaxValue){
    motors.set(-.5);
  }
  motors.set(0);
}

public void raiseRamp(){
  while(encoderLeft.get() > 0 ||
   encoderRight.get() > 0 ){
    motors.set(0.5);
  }
  motors.set(0);
}

}
