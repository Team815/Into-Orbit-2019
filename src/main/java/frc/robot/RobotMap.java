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

  public static final int PORT_AXIS_LJX = 0; // Left Joystick - X
  public static final int PORT_AXIS_LJY = 1; // Left Joystick - Y
  public static final int PORT_AXIS_LT = 2; // Left Trigger
  public static final int PORT_AXIS_RT = 3; // Right Trigger
  public static final int PORT_AXIS_RJX = 4; // Right Joystick - X
  public static final int PORT_AXIS_RJY = 5; // Right Joystick - Y

  public static final int PORT_BUTTON_A = 1;
  public static final int PORT_BUTTON_B = 2;
  public static final int PORT_BUTTON_X = 3;
  public static final int PORT_BUTTON_Y = 4;
  public static final int PORT_BUTTON_LB = 5; // Left Bumper
  public static final int PORT_BUTTON_RB = 6; // Right Bumber
  public static final int PORT_BUTTON_SELECT = 7;
  public static final int PORT_BUTTON_START = 8;
  public static final int PORT_BUTTON_LJ = 9; // Left Joystick
  public static final int PORT_BUTTON_RJ = 10; // Right Joystick

  public static int PORT_DPAD_UP;
  public static int PORT_DPAD_UP_RIGHT;
  public static int PORT_DPAD_RIGHT;
  public static int PORT_DPAD_DOWN_RIGHT;
  public static int PORT_DPAD_DOWN;
  public static int PORT_DPAD_DOWN_LEFT;
  public static int PORT_DPAD_LEFT;
  public static int PORT_DPAD_UP_LEFT;

  
  public static final int PORT_MOTOR_DRIVE_FRONT_RIGHT = 3;
	public static final int PORT_MOTOR_DRIVE_REAR_RIGHT = 1;
	public static final int PORT_MOTOR_DRIVE_FRONT_LEFT = 4;
  public static final int PORT_MOTOR_DRIVE_REAR_LEFT = 2;

  public static final int PORT_MOTOR_RAMP_FRONT_LEFT_1 = 1;
  public static final int PORT_MOTOR_RAMP_FRONT_LEFT_2 = 2;
  public static final int PORT_MOTOR_RAMP_FRONT_RIGHT_1 = 3;
  public static final int PORT_MOTOR_RAMP_FRONT_RIGHT_2 = 4;
  public static final int PORT_MOTOR_RAMP_REAR_LEFT = 5;
  public static final int PORT_MOTOR_RAMP_REAR_RIGHT = 6;

  public static final int PORT_MOTOR_HOOK = 7;
  public static final int PORT_MOTOR_LATCH = 8;

  public static final int[] PORT_ENCODER_HOOK = { 2, 3};
  public static final int[] PORT_ENCODER_LATCH = { 6, 7 };
}
