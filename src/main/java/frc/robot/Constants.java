// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import frc.robot.utils.SwerveModuleConfig;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final static class kSwerveDrive {
        public static final Mk4SwerveModuleHelper.GearRatio GEAR_RATIO = Mk4SwerveModuleHelper.GearRatio.L1;
        public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0;
        public static final double DRIVETRAIN_WHEELBASE_METERS = 0;
        public static final double MAX_VELOCITY_METERS_PER_SECOND = 0;
        public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = 0;
        public static final double MAX_VOLTAGE = 0;

        public static final SwerveModuleConfig FRONT_LEFT = new SwerveModuleConfig(-1,-1,-1, 0.0);
        public static final SwerveModuleConfig FRONT_RIGHT = new SwerveModuleConfig(-1, -1, -1, 0.0);
        public static final SwerveModuleConfig BACK_LEFT = new SwerveModuleConfig(-1, -1, -1, 0.0);
        public static final SwerveModuleConfig BACK_RIGHT = new SwerveModuleConfig(-1, -1, -1, 0.0);
    }
    public final static class kOI {
        public static final int DRIVE_CONTROLLER = 1;
    }
}
