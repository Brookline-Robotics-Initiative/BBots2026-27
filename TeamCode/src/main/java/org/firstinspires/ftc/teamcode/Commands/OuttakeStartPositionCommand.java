package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.TrebushotOuttake;
import org.firstinspires.ftc.teamcode.Utils.Utils;

public class OuttakeStartPositionCommand extends CommandBase {
  private final TrebushotOuttake outtake;

  public OuttakeStartPositionCommand(TrebushotOuttake outtake) {
    this.outtake = outtake;
    addRequirements(outtake);
  }

  @Override
  public void execute() {
    outtake.toStartPosition();
  }

  @Override
  public boolean isFinished() {
    return Utils.isWithinTolerance(
        Constants.OuttakeConstants.OUTTAKE_START_POSITION,
        outtake.getPosition(),
        Constants.OuttakeConstants.OUTTAKE_TOLERANCE);
  }

  @Override
  public void end(boolean interrupted) {
    outtake.stop();
  }
}
