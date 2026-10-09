package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Intake extends SubsystemBase {
    private final MotorEx intakeMotor;
    private Telemetry telemetry;

    private final double MAX_VELOCITY = Constants.IntakeConstants.INTAKE_MAX_VELOCITY;
    private final double MIN_VELOCITY = 0; //why is it 1 and not 0?

    public Intake(final HardwareMap hwMap, Telemetry telemetry){
        this.telemetry = telemetry;
        intakeMotor = new MotorEx(hwMap, Constants.IntakeConstants.INTAKE_ID);
        intakeMotor.setRunMode(Motor.RunMode.VelocityControl); //pls need explanation
        //intakeMotor.setInverted(true); -- if needed
    }

    private void setVelocity(final double velocity){
        //if (Math.abs(velocity) <= MAX_VELOCITY){
        intakeMotor.setVelocity(velocity);
        //}
    }

    public double getVelocity(){
        return intakeMotor.getVelocity();
    }

    public void intake(){
        setVelocity(-1 * Constants.IntakeConstants.INTAKE_VELOCITY);
    }

    public void expel(){
        setVelocity(Constants.IntakeConstants.EXPEL_VELOCITY);
    }

    public void stop(){
        intakeMotor.stopMotor();
    }
}
