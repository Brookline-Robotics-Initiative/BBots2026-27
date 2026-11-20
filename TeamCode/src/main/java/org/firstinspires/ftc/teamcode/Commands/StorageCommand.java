package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.Storage;

public class StorageCommand extends CommandBase {
  private final Storage storage;

  public StorageCommand(Storage storage) {
    this.storage = storage;
    addRequirements(storage);
  }

  @Override
  public void execute() {
    storage.store();
  }

  @Override
  public void end(boolean interrupted) {
    storage.stop();
  }
}
