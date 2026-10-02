package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystems.Spindexer;

import java.util.concurrent.TimeUnit;

public class SpindexerAgitateCommand extends CommandBase {
    private final Spindexer spindexer;
    private final Timing.Stopwatch stopwatch = new Timing.Stopwatch(TimeUnit.MILLISECONDS);

    public SpindexerAgitateCommand(Spindexer spindexer){
        this.spindexer = spindexer;
        addRequirements(spindexer);

    }

    @Override
    public void execute(){
        stopwatch.start();
        while(stopwatch.deltaTime() <= 500){
            spindexer.spin();
        }
        while(stopwatch.deltaTime() > 500 && stopwatch.deltaTime() <= 1000){
            spindexer.backspin();
        }
    }

    @Override
    public void end(boolean interrupted){
        spindexer.stop();
    }
}
