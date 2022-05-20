package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {


    public static double getLeftStickX(XboxController controller) {
        return controller.getLeftX();
    }

    public static double getLeftStickY(XboxController controller) {
        return controller.getLeftY();
    }
    
    public static double getRightStickX(XboxController controller) {
        return controller.getRightX();
    }
}