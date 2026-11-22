package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Storage;

public class ExpelBothCommand extends ParallelCommandGroup {
  public ExpelBothCommand(Intake intake, Storage storage) {
    addCommands(new ExpelIntakeCommand(intake), new StorageExpelCommand(storage));
    addRequirements(intake, storage);
  }
}
