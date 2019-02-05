/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int buttonPortA = 1;
  public static int buttonPortB = 2;
  public static int buttonPortX = 3;
  public static int buttonPortY = 4;

  public static int buttonPortLB = 5;
  public static int buttonPortRB = 6;

  public static int buttonPortLT;
  public static int buttonPortRT;

  public static int buttonPortL3 = 9;
  public static int buttonPortR3 = 10;

  public static int buttonPortSelect = 7;
  public static int buttonPortStart = 8;

  public static int buttonPortDpadUp;
  public static int buttonPortDpadDown;
  public static int buttonPortDpadLeft;
  public static int buttonPortDpadRight;

  
  public static final int MOTOR_PORT_FRONT_RIGHT = 3;
	public static final int MOTOR_PORT_REAR_RIGHT = 1;
	public static final int MOTOR_PORT_FRONT_LEFT = 4;
  public static final int MOTOR_PORT_REAR_LEFT = 2;
}
