package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.Storage;

public class StorageExpelCommand extends CommandBase {
  private final Storage storage;

  public StorageExpelCommand(Storage storage) {
    this.storage = storage;
    addRequirements(storage);
  }

  @Override
  public void execute() {
    storage.expel();
  }

  @Override
  public void end(boolean interrupted) {
    storage.stop();
  }
}
