package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.ColorSensor;

public class SenseColorsCommand extends CommandBase {
  private final ColorSensor colorSensor;

  public SenseColorsCommand(ColorSensor colorSensor) {
    this.colorSensor = colorSensor;
    addRequirements(colorSensor);
  }

  @Override
  public void execute() {
    colorSensor.getColors();
  }

  @Override
  public void end(boolean interrupted) {}
}
