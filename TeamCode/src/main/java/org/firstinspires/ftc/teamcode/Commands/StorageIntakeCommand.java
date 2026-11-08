package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.StorageServo;

public class StorageIntakeCommand extends CommandBase {
  private StorageServo storageServo;

  public StorageIntakeCommand(StorageServo storageServo) {
    this.storageServo = storageServo;
    addRequirements(storageServo);
  }

  @Override
  public void execute() {
    storageServo.intake();
  }

  @Override
  public void end(boolean interrupted) {
    storageServo.stop();
  }
}
