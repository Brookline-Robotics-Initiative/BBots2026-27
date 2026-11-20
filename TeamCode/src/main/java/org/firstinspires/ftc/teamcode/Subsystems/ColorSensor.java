package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.SensorRevColorV3;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Constants.ColorSensorConstants;
import org.firstinspires.ftc.teamcode.Constants.ColorSensorConstants.*;
import org.firstinspires.ftc.teamcode.Utils.Utils;

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
    telemetry.addData("seesBlueNectar:", this.seesBlueNectar());
    telemetry.addData("seesRedNectar", this.seesRedNectar());
    telemetry.addData("seesPollen:", this.seesPollen());
    telemetry.addData("seesAnything:", this.seesAnything());
    telemetry.update();
  }

  public boolean seesBlueNectar() {
    if (Utils.isWithinTolerance(
        ColorSensorConstants.BLUENECTAR_BLUEVALUE,
        colorSensor.blue(),
        ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
      if (Utils.isWithinTolerance(
          ColorSensorConstants.BLUENECTAR_REDVALUE,
          colorSensor.red(),
          ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
        if (Utils.isWithinTolerance(
            ColorSensorConstants.BLUENECTAR_GREENVALUE,
            colorSensor.green(),
            ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean seesRedNectar() {
    if (Utils.isWithinTolerance(
        ColorSensorConstants.REDNECTAR_BLUEVALUE,
        colorSensor.blue(),
        ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {

      if (Utils.isWithinTolerance(
          ColorSensorConstants.REDNECTAR_REDVALUE,
          colorSensor.red(),
          ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {

        if (Utils.isWithinTolerance(
            ColorSensorConstants.REDNECTAR_GREENVALUE,
            colorSensor.green(),
            ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean seesPollen() {
    if (Utils.isWithinTolerance(
        ColorSensorConstants.POLLEN_BLUEVALUE,
        colorSensor.blue(),
        ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
      if (Utils.isWithinTolerance(
          ColorSensorConstants.POLLEN_REDVALUE,
          colorSensor.red(),
          ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
        if (Utils.isWithinTolerance(
            ColorSensorConstants.POLLEN_GREENVALUE,
            colorSensor.green(),
            ColorSensorConstants.COLOR_SENSOR_TOLERANCE)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean seesAnything() {
    if (seesBlueNectar() || seesRedNectar() || seesPollen()) {
      return true;
    }
    return false;
  }
}
