/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class AnalogButton extends Trigger {

    private Joystick joystick;
    private int axis;

    public AnalogButton(Joystick joystick, int axis) {
        this.joystick = joystick;
        this.axis = axis;
    }

    @Override
    public boolean get() {
        return joystick.getRawAxis(axis) > 0.2;
    }
}
