/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;

public class SetRampColor extends Command {

  public enum Color {
    RED(0),
    BLUE(1);

    private int i;

    private Color(int i) {
      this.i = i;
    }

    public byte toByte() {
      return (byte)i;
    }
  };

  //private static final SerialPort port = new SerialPort(9600, SerialPort.Port.kUSB);
  private Color color;

  public SetRampColor(Color color) {
    this.color = color;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //port.write(new byte[] {color.toByte()}, 1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
