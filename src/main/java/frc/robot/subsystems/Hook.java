/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveHookManually;

/**
 * Add your docs here.
 */
public class Hook extends Subsystem {

  public static final int ENCODER_MAX_VALUE = 1000;
  public boolean hasBeenReset;
  private Encoder encoder;
  private DigitalInput limitSwitch;
  private WPI_TalonSRX motorHook;

  public Hook() {
    hasBeenReset = false;
    motorHook = new WPI_TalonSRX(RobotMap.PORT_MOTOR_HOOK);
    encoder = new Encoder(RobotMap.PORT_ENCODER_HOOK[0], RobotMap.PORT_ENCODER_HOOK[1]);
    limitSwitch = new DigitalInput(RobotMap.PORT_LIMITSWITCH_HOOK);
  }

  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveHookManually());
  }
  
  public void moveManually(double speed) {
    speed = Math.abs(speed) > .1 ? speed : 0;
    motorHook.set(speed*.5);
  }
  
  public void moveUp() {
    motorHook.set(.5);
  }
  
  public void moveDown() {
    motorHook.set(-.5);
  }
  
  public void stopHook() {
    motorHook.set(0);
  }

  public int getEncoderValue() {
    return encoder.get();
  }

  public boolean limitSwitchIsPressed() {
    return limitSwitch.get();
  }
}
