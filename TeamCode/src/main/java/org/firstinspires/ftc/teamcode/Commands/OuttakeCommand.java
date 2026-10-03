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
        outtake.outtake();
    }
    @Override
    public void end(boolean interrupted){outtake.stop();}
}
