package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Spindexer;


public class SpindexerOutCommand extends CommandBase {
    private final Spindexer spindexer;

    public SpindexerOutCommand(Spindexer spindexer){
        this.spindexer = spindexer;
        addRequirements(spindexer);

    }

    @Override
    public void execute(){
        spindexer.spin();
    }

    @Override
    public void end(boolean interrupted){
        spindexer.stop();
    }
}
