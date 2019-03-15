/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AdjustMaxSpeed;
import frc.robot.commands.AutoDriveBackwards;
import frc.robot.commands.AutoDriveForward;
import frc.robot.commands.MoveHook;
import frc.robot.commands.ResetPlayerAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick controllerDriver = new Joystick(0);
  public Joystick controllerOperator = new Joystick(1);
  public Button LB;
  public Button RB;
  public Button B;
  public Button A;
  public Button SELECT;
  public Button START;

  public OI() {
    LB = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_LB);
    RB = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_RB);
    B = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_B);
    A = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_A);
    SELECT = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_SELECT);
    START = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_START);

    LB.whenPressed(new AdjustMaxSpeed(-0.1));
    RB.whenPressed(new AdjustMaxSpeed(0.1));
    B.whenPressed(new ResetPlayerAngle());
    A.whenPressed(new MoveHook());
    SELECT.whileHeld(new AutoDriveForward());
    START.whileHeld(new AutoDriveBackwards());
  }

}
