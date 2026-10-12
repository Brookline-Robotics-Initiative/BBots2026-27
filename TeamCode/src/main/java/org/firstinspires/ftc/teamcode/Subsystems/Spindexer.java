package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.Constants;

public class Spindexer extends SubsystemBase {
    private final MotorEx spindexer;

    private final double MAX_VELOCITY = Constants.SpindexerConstants.SPIN_MAX_VELOCITY;
    private final double MIN_VELOCITY = 1;

    public Spindexer(final HardwareMap hwMap){
        spindexer = new MotorEx(hwMap, Constants.SpindexerConstants.SPIN_ID); //TODO: add motor type
        spindexer.setRunMode(MotorEx.RunMode.VelocityControl);
    }

    private void setVelocity(final double velocity){
        if(velocity >= MIN_VELOCITY && velocity <= MAX_VELOCITY){
            spindexer.setVelocity(velocity);
        }
    }

    public double getVelocity(){return spindexer.getVelocity();}

    public void spin(){
        setVelocity(Constants.SpindexerConstants.SPIN_VELOCITY);
    }

    public void backspin(){
        setVelocity(-Constants.SpindexerConstants.SPIN_VELOCITY);
    }

    public void stop(){
        spindexer.setRunMode(Motor.RunMode.RawPower);
        spindexer.set(0);
        spindexer.setRunMode(Motor.RunMode.VelocityControl);
    }

}
