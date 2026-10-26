package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.DistSensor;

public class SenseDistanceCommand extends CommandBase {
  private final DistSensor distanceSensor;

  public SenseDistanceCommand(DistSensor distanceSensor) {
    this.distanceSensor = distanceSensor;
    addRequirements(distanceSensor);
  }

  @Override
  public void execute() {
    distanceSensor.getDistances();
  }

  @Override
  public void end(boolean interrupted) {}
}
