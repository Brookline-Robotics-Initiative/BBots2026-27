package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.TrebushotOuttake;

public class OuttakeEndPositionCommand extends CommandBase {
    private final TrebushotOuttake outtake;
    public OuttakeEndPositionCommand(TrebushotOuttake outtake){
        this.outtake = outtake;
        addRequirements(outtake);
    }

    @Override
    public void execute(){
        outtake.toEndPosition();
    }
    @Override
    public void end(boolean interrupted){
        outtake.stop();
    }
}
