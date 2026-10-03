package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PController;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.Constants;

public class Outtake extends SubsystemBase {
    private final MotorEx outtakeMotor;
    private final Motor.Encoder encoder;
    private final double MAX_VELOCITY = Constants.OuttakeConstants.OUTTAKE_MAX_VELOCITY;
    private final double MIN_VELOCITY = 1;
    private final int RESET_POSITION = Constants.OuttakeConstants.OUTTAKE_START_POSITION;
    //private final PIDFController pidf;

    public Outtake(final HardwareMap hwMap){
        outtakeMotor = new MotorEx (hwMap, Constants.OuttakeConstants.OUTTAKE_ID);
        encoder = outtakeMotor.encoder;
        outtakeMotor.setRunMode(Motor.RunMode.VelocityControl);
        //pidf = new PIDFController(0.0, 0.0, 0.0, 0.0); //TODO
    }

    public void setVelocity(final double velocity){
        if (velocity >= MIN_VELOCITY && velocity <= MAX_VELOCITY) {
            outtakeMotor.setVelocity(velocity);
        }
    }

    public void outtake(){
        outtakeMotor.setVelocity(Constants.OuttakeConstants.OUTTAKE_SPEED);
    }

//    public void resetToStartPosition(){
//        //FIXME Matthew is worried we are doing math that doesn't make sense to do
//        int currentPos = (int)(outtakeMotor.getCurrentPosition()/(encoder.getRevolutions() * outtakeMotor.getCPR()));
//
//
//        //FIXME I don't feel that confident in the PID controller stuff so please check over
//        while (!pidf.atSetPoint()) {
//            double output = pidf.calculate(currentPos, RESET_POSITION);
//            outtakeMotor.setVelocity(output);
//        }
//        outtakeMotor.stopMotor();
//    }

    public void stop(){
        outtakeMotor.stopMotor();
    }
}
