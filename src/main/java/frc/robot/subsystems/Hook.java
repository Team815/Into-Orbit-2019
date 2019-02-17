/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.MoveHook;

/**
 * Add your docs here.
 */
public class Hook extends Subsystem {

  SpeedControllerGroup motorHook;

  private int inputPort;

  public Hook (int portMotorHook, int inputPort) {
    WPI_TalonSRX motorHook = new WPI_TalonSRX(portMotorHook);
    motorHook = new SpeedControllerGroup(motorHook);
    this.inputPort = inputPort;
    /*
    encoderHook = new Encoder(
      RobotMap.PORT_ENCODER_HOOK[0]
    );

    encoderMaxValue = 1000;
    */
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveHook(this, inputPort));
  }

  public void move(double speed) {
    speed = Math.abs(speed) < 0.1 ? 0 : speed;
    motorHook.set(speed);
  }
}
