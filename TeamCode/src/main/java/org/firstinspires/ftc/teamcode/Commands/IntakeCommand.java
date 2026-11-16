package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Alliance;
import org.firstinspires.ftc.teamcode.Subsystems.ColorSensor;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class IntakeCommand extends CommandBase {
  private final Intake intake;
  private final ColorSensor sensor;

  public IntakeCommand(Intake intake, ColorSensor sensor) {
    this.intake = intake;
    this.sensor = sensor;
    addRequirements(intake);
  }

  @Override
  public void execute() {
    intake.intake();
    if (Alliance.getAlliance() == Alliance.alliance.RedAlliance) {
      if (sensor.seesBlueNectar()) {
        intake.expel();
      }
    } else if (Alliance.getAlliance() == Alliance.alliance.BlueAlliance) {
      if (sensor.seesRedNectar()) {
        intake.expel();
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    intake.stop();
  }
}
