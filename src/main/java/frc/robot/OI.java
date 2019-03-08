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
import frc.robot.commands.Align;
import frc.robot.commands.MoveHook;
import frc.robot.commands.ResetPlayerAngle;
import frc.robot.commands.SetRampColor;

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
  public Button driverLB = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_LB);
  public Button driverRB = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_RB);
  public Button driverB = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_B);
  public Button driverA = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_A);
  public Button driverX = new JoystickButton(controllerDriver, RobotMap.PORT_BUTTON_X);
  public Button operatorX = new JoystickButton(controllerOperator, RobotMap.PORT_BUTTON_X);
  public Button operatorB = new JoystickButton(controllerOperator, RobotMap.PORT_BUTTON_B);
  
  public OI (){

    driverLB.whenPressed(new AdjustMaxSpeed(-0.1));
    driverRB.whenPressed(new AdjustMaxSpeed(0.1));
    driverB.whenPressed(new ResetPlayerAngle());
    driverA.whenPressed(new MoveHook());
    driverX.whenActive(new Align());
    operatorX.whenPressed(new SetRampColor(SetRampColor.Color.BLUE));
    operatorB.whenPressed(new SetRampColor(SetRampColor.Color.RED));
  }

}
