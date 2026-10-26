package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Constants;

public class DistSensor extends SubsystemBase {
  private final DistanceSensor distanceSensor;
  private Telemetry telemetry;

  public DistSensor(final HardwareMap hwMap, Telemetry telemetry) {
    this.telemetry = telemetry;
    distanceSensor =
        hwMap.get(DistanceSensor.class, Constants.DistanceSensorConstants.DISTANCE_SENSOR_ID);
  }

  public void getDistances() {
    telemetry.addData("current distance", distanceSensor.getDistance(DistanceUnit.CM));
    telemetry.update();
  }
}
