package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import org.firstinspires.ftc.teamcode.Constants;

public class SnailOuttake extends SubsystemBase {
    private final MotorEx outtakeMotor;
    private final double MAX_VELOCITY = Constants.OuttakeConstants.OUTTAKE_MAX_VELOCITY;
    private final double MIN_VELOCITY = 1;

    public SnailOuttake(final HardwareMap hwMap){
        outtakeMotor = new MotorEx (hwMap, Constants.OuttakeConstants.OUTTAKE_ID); //TODO add motor type
        outtakeMotor.setRunMode(Motor.RunMode.VelocityControl);
        outtakeMotor.setBuffer(1.0);
    }
    public void setPower(final double power) {
        outtakeMotor.set(power);
    }

    public void outtake() {outtakeMotor.setVelocity(Constants.OuttakeConstants.OUTTAKE_SPEED);}

    public void stop(){
        outtakeMotor.setRunMode(Motor.RunMode.RawPower);
        outtakeMotor.set(0);
        outtakeMotor.setRunMode(Motor.RunMode.VelocityControl);
    }
}
