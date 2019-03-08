/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * Add your docs here.
 */
public class Camera implements PIDSource {

  private PIDSourceType pidSource;
  private NetworkTableEntry tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");

  @Override
  public void setPIDSourceType(PIDSourceType pidSource) {
    this.pidSource = pidSource;
  }

  @Override
  public PIDSourceType getPIDSourceType() {
    return pidSource;
  }

  @Override
  public double pidGet() {
    return tx.getDouble(0);
  }
}
