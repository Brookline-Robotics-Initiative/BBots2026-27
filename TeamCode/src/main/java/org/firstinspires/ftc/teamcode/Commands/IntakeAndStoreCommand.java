package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.ParallelCommandGroup;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Storage;

public class IntakeAndStoreCommand extends ParallelCommandGroup {
  public IntakeAndStoreCommand(Intake intake, Storage storage) {
    addCommands(new IntakeCommand(intake), new StorageCommand(storage));
    addRequirements(intake, storage);
  }
}
