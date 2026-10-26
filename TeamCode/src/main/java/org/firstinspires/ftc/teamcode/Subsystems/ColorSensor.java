package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SensorRevColorV3;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class ColorSensor extends SubsystemBase {
  private final SensorRevColorV3 colorSensor;
  private Telemetry telemetry;

  public ColorSensor(final HardwareMap hwMap, Telemetry telemetry) {
    this.telemetry = telemetry;
    colorSensor = new SensorRevColorV3(hwMap, Constants.ColorSensorConstants.COLOR_SENSOR_ID);
  }

  public void getColors() {
    telemetry.addData("red", colorSensor.red());
    telemetry.addData("blue", colorSensor.blue());
    telemetry.addData("green", colorSensor.green());
    telemetry.update();
  }
}
