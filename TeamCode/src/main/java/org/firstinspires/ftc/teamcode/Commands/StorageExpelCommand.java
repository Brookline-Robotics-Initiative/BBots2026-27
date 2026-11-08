package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.StorageServo;

public class StorageExpelCommand extends CommandBase {
  private StorageServo storageServo;

  public StorageExpelCommand(StorageServo storageServo) {
    this.storageServo = storageServo;
    addRequirements(storageServo);
  }

  @Override
  public void execute() {
    storageServo.expel();
  }

  @Override
  public void end(boolean interrupted) {
    storageServo.stop();
  }
}
