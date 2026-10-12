package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Outtake;

public class OuttakeCommand extends CommandBase {

    private final Outtake outtake;
    public OuttakeCommand(Outtake outtake){
        this.outtake = outtake;
        addRequirements(outtake);
    }

    @Override
    public void execute(){
        outtake.setPower(1.0);
    }
    @Override
    public void end(boolean interrupted){
        outtake.stop();
    }
}
