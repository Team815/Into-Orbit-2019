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

/**
 * Add your docs here.
 */
public class Latch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static final int ENCODER_MAX_VALUE = 200;
  public static final int ENCODER_MIN_VALUE = 0;
  private double LATCH_MAX_SPEED = .15;
  private Encoder encoder;
  private WPI_TalonSRX latchHook;
  private boolean locked;

  public Latch(){
    encoder = new Encoder(RobotMap.PORT_ENCODER_LATCH[0], RobotMap.PORT_ENCODER_LATCH[1]);
    latchHook = new WPI_TalonSRX(RobotMap.PORT_MOTOR_LATCH);
    locked = true;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void lock(){
    latchHook.set(LATCH_MAX_SPEED);
    locked = true;
  }

  public void unlock(){
    latchHook.set(-LATCH_MAX_SPEED);
    locked = false;
  }

  public void stop(){
    latchHook.set(0);
  }

  public int getEncoder(){
    return encoder.get();
  }

  public boolean isLocked(){
    return locked;
  }
}
