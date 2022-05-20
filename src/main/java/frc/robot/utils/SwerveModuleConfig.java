package frc.robot.utils;

import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;

import frc.robot.Constants;


public class SwerveModuleConfig {
    public final Mk4SwerveModuleHelper.GearRatio GEAR_RATIO;
    public final int POWER_ID;
    public final int STEER_ID;
    public final int ENCODER_ID;
    public final double STEER_OFFSET;

    public SwerveModuleConfig(int POWER_ID, int STEER_ID, int ENCODER_ID, double STEER_OFFSET) {
        this.POWER_ID = POWER_ID;
        this.STEER_ID = STEER_ID;
        this.ENCODER_ID = ENCODER_ID;
        this.STEER_OFFSET = STEER_OFFSET;
        this.GEAR_RATIO = Constants.kSwerveDrive.GEAR_RATIO;
    }

    public SwerveModule createNeoModule() {
        return Mk4SwerveModuleHelper.createNeo(
                GEAR_RATIO,
                POWER_ID,
                STEER_ID,
                ENCODER_ID,
                STEER_OFFSET);
    }
}
