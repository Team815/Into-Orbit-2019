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
import frc.robot.commands.ManuallyControlRearRamp;

/**
 * Add your docs here.
 */
public class RearRamp extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX rearRampMotorRight;
  WPI_TalonSRX rearRampMotorLeft;
  SpeedControllerGroup rearRampMotors;
  Encoder encoderRight;
  Encoder encoderLeft;
  private int encoderMaxValue;

  public RearRamp (){
    rearRampMotorRight = new WPI_TalonSRX(RobotMap.MOTOR_PORT_REAR_RAMP_RIGHT);
    rearRampMotorLeft = new WPI_TalonSRX(RobotMap.MOTOR_PORT_REAR_RAMP_LEFT);
    rearRampMotorRight.setInverted(true);
    rearRampMotors = new SpeedControllerGroup(rearRampMotorRight, rearRampMotorLeft);
    encoderRight = new Encoder(0,1);
    encoderLeft = new Encoder(7,8);
    encoderMaxValue = 1000;

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ManuallyControlRearRamp());
  }

public void moveRamp(double speed){
  rearRampMotors.set(-speed);
}

public void lowerRamp(){
  while(encoderLeft.get() < encoderMaxValue ||
   encoderRight.get() < encoderMaxValue){
    rearRampMotors.set(-.5);
  }
  rearRampMotors.set(0);
}

public void raiseRamp(){
  while(encoderLeft.get() > 0 ||
   encoderRight.get() > 0 ){
    rearRampMotors.set(0.5);
  }
  rearRampMotors.set(0);
}

}
