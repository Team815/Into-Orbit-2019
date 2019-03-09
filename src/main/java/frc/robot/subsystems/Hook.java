/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANDigitalInput.LimitSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
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
  public static boolean hasBeenReset;
  private Encoder encoder;
  private DigitalInput limitSwitch;
  private WPI_TalonSRX motorHook;

  public Hook () {
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

  public boolean moveUp() {
    motorHook.set(.5);
    if(encoder.get() >= ENCODER_MAX_VALUE) {
      return true;
    }
    else return false;
  }

  public boolean moveDown() {
    motorHook.set(-.5);
    return limitSwitch.get();
  }

  public void stopHook() {
    motorHook.set(0);
  }
}
