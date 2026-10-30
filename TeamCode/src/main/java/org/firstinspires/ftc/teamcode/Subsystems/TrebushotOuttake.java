package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.Constants;

public class TrebushotOuttake extends SubsystemBase {

    private final MotorEx outtakeMotor;

    private final double tolerance = 0.1;
    private final double kP = 0.01;


    public TrebushotOuttake(final HardwareMap hwMap){
        outtakeMotor = new MotorEx(hwMap, Constants.OuttakeConstants.OUTTAKE_ID);
        outtakeMotor.setRunMode(Motor.RunMode.PositionControl);
        outtakeMotor.setPositionCoefficient(kP);
        outtakeMotor.setPositionTolerance(tolerance);
    }

    public void toStartPosition(){
        outtakeMotor.set(Constants.OuttakeConstants.OUTTAKE_START_POSITION);
    }

    public void toEndPosition(){
        outtakeMotor.set(Constants.OuttakeConstants.OUTTAKE_TARGET_POSITION);
    }

    public void stop(){
        outtakeMotor.setRunMode(Motor.RunMode.RawPower);
        outtakeMotor.set(0);
        outtakeMotor.setRunMode(Motor.RunMode.PositionControl);
    }
}
