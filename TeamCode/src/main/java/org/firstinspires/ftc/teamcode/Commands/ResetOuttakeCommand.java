package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Outtake;

public class ResetOuttakeCommand extends CommandBase {
    private Outtake outtake;

    public ResetOuttakeCommand(Outtake outtake){
        this.outtake = outtake;
        addRequirements(outtake);
    }

    @Override
    public void execute(){
        //outtake.resetToStartPosition();
    }

    public void end(boolean interrupted){outtake.stop();}

    @Override
    public boolean isFinished(){
        // FIXME: finish once the reset position is reached. Otherwise, just make this a pseudo stop command.
        return true;
    }
}
