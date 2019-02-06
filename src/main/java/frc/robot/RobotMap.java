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

  public static final int AXIS_PORT_LJX = 0; // Left Joystick - X
  public static final int AXIS_PORT_LJY = 1; // Left Joystick - Y
  public static final int AXIS_PORT_LT = 2; // Left Trigger
  public static final int AXIS_PORT_RT = 3; // Right Trigger
  public static final int AXIS_PORT_RJX = 4; // Right Joystick - X
  public static final int AXIS_PORT_RJY = 5; // Right Joystick - Y

  public static final int BUTTON_PORT_A = 1;
  public static final int BUTTON_PORT_B = 2;
  public static final int BUTTON_PORT_X = 3;
  public static final int BUTTON_PORT_Y = 4;
  public static final int BUTTON_PORT_LB = 5; // Left Bumper
  public static final int BUTTON_PORT_RB = 6; // Right Bumber
  public static final int BUTTON_PORT_SELECT = 7;
  public static final int BUTTON_PORT_START = 8;
  public static final int BUTTON_PORT_LJ = 9; // Left Joystick
  public static final int BUTTON_PORT_RJ = 10; // Right Joystick

  public static int buttonPortDpadUp;
  public static int buttonPortDpadDown;
  public static int buttonPortDpadLeft;
  public static int buttonPortDpadRight;

  
  public static final int MOTOR_PORT_FRONT_RIGHT = 3;
	public static final int MOTOR_PORT_REAR_RIGHT = 1;
	public static final int MOTOR_PORT_FRONT_LEFT = 4;
  public static final int MOTOR_PORT_REAR_LEFT = 2;
}
