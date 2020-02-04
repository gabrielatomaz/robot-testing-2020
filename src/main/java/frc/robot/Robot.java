/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private SpeedControllerGroup motorsLeft;
  private SpeedControllerGroup motorsRight;
  private DifferentialDrive driver;

  private Joystick pilot;

  @Override
  public void robotInit() {
    this.motorsRight = new SpeedControllerGroup(new Talon(0), new Talon(1), new Talon(2));
    this.motorsLeft = new SpeedControllerGroup(new Talon(3), new Talon(4), new Talon(5));

    this.driver = new DifferentialDrive(this.motorsRight, this.motorsLeft);
  }

  @Override
  public void teleopPeriodic() {
    this.driver.arcadeDrive(pilot.getY(), pilot.getRawAxis(4));
  }
}
