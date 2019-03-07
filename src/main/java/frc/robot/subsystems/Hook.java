/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveHookManually;

/**
 * Add your docs here.
 */
public class Hook extends Subsystem {

  private final int ENCODER_MAX_VALUE = 1000;
  private final int ENCODER_MIN_VALUE = 0;
  private Encoder encoder;
  private WPI_TalonSRX motorHook;

  public Hook () {
    motorHook = new WPI_TalonSRX(RobotMap.PORT_MOTOR_HOOK);
    encoder = new Encoder(RobotMap.PORT_ENCODER_HOOK[0], RobotMap.PORT_ENCODER_HOOK[1]);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveHookManually());
  }

  public void moveManually(double speed) {
    speed = Math.abs(speed) > .1 ? speed : 0;
    motorHook.set(speed*.5);
  }

  public boolean move() {
    if(encoder.get() <= ENCODER_MIN_VALUE){
      return moveUp();
    }else{
      return moveDown();
    }
  }

  private boolean moveUp() {
    if(encoder.get() < ENCODER_MAX_VALUE){
      motorHook.set(.5);
      return false;
    }else{
      motorHook.set(0);
      return true;
    }
  }

  private boolean moveDown() {
    if(encoder.get() > ENCODER_MIN_VALUE){
      motorHook.set(.5);
      return false;
    }else{
      motorHook.set(0);
      return true;
    }
  }
}
