// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.swervedrivespecialties.swervelib.Mk3ModuleConfiguration;
import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SdsModuleConfigurations;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.kSwerveDrive;

import com.swervedrivespecialties.swervelib.SwerveModule;

public class SwerveDrive extends SubsystemBase {
  private final SwerveModule frontLeft;
  private final SwerveModule frontRight;
  private final SwerveModule backLeft;
  private final SwerveModule backRight;
  private ChassisSpeeds chassisSpeeds = new ChassisSpeeds(0.0, 0.0, 0.0);

  private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
      // Front left
      new Translation2d(kSwerveDrive.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
          kSwerveDrive.DRIVETRAIN_WHEELBASE_METERS / 2.0),
      // Front right
      new Translation2d(kSwerveDrive.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
          -kSwerveDrive.DRIVETRAIN_WHEELBASE_METERS / 2.0),
      // Back left
      new Translation2d(-kSwerveDrive.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
          kSwerveDrive.DRIVETRAIN_WHEELBASE_METERS / 2.0),
      // Back right
      new Translation2d(-kSwerveDrive.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
          -kSwerveDrive.DRIVETRAIN_WHEELBASE_METERS / 2.0));

  public SwerveDrive() {
    frontLeft = Constants.kSwerveDrive.FRONT_LEFT.createNeoModule();
    frontRight = Constants.kSwerveDrive.FRONT_RIGHT.createNeoModule();
    backLeft = Constants.kSwerveDrive.BACK_LEFT.createNeoModule();
    backRight = Constants.kSwerveDrive.BACK_RIGHT.createNeoModule();
  }

  public void drive(double leftX, double leftY, double rightX) {

    this.chassisSpeeds = new ChassisSpeeds(
      leftX*kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND, 
      leftY*kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND, 
      rightX*kSwerveDrive.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND);
  }

  @Override
  public void periodic() {
    SwerveModuleState[] states = kinematics.toSwerveModuleStates(chassisSpeeds);
    SwerveDriveKinematics.desaturateWheelSpeeds(states, kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND);
    frontLeft.set(
        states[0].speedMetersPerSecond / kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND * kSwerveDrive.MAX_VOLTAGE,
        states[0].angle.getRadians());
    frontRight.set(
        states[1].speedMetersPerSecond / kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND * kSwerveDrive.MAX_VOLTAGE,
        states[1].angle.getRadians());
    backLeft.set(
        states[2].speedMetersPerSecond / kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND * kSwerveDrive.MAX_VOLTAGE,
        states[2].angle.getRadians());
    backRight.set(
        states[3].speedMetersPerSecond / kSwerveDrive.MAX_VELOCITY_METERS_PER_SECOND * kSwerveDrive.MAX_VOLTAGE,
        states[3].angle.getRadians());
  }
}
