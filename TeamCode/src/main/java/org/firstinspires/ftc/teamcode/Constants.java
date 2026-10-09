package org.firstinspires.ftc.teamcode;

public class Constants {

  public static class RobotConstants {
    public static final double ROBOT_MASS = 8.5; // in kilograms
    // pinpoint constants
    public static final double FORWARD_POD_OFFSET = 3.125;
    public static final double STRAFE_POD_OFFSET = -1.625;
  }

  public static class DriveConstants {
    public static final String FRONT_LEFT_MOTOR_ID = "frontLeftMotor";
    public static final String FRONT_RIGHT_MOTOR_ID = "frontRightMotor";
    public static final String BACK_LEFT_MOTOR_ID = "backLeftMotor";
    public static final String BACK_RIGHT_MOTOR_ID = "backRightMotor";

    public static final String IMU_ID = "imu";
  }

    public static class IntakeConstants {
        public static final String INTAKE_ID = "intakeMotor";
        public static final double INTAKE_VELOCITY = 140; //FIXME: test and change
        public static final double EXPEL_VELOCITY = 140; //FIXME: test and change
        public static final double INTAKE_MAX_VELOCITY = 300; // in RPM, 312 //FIXME: test and chance
    }
  public static class SpindexerConstants {
    public static final String SPIN_ID = "spindexerMotor";

    public static final double SPIN_VELOCITY = 1000; //TODO: Change
    public static final double SPIN_MAX_VELOCITY = 7000; //rpm
  }
}
