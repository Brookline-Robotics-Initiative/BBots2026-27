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

  public boolean seesBlueNectar() {
    if (colorSensor.blue()>Constants.ColorSensorConstants.BLUENECTAR_BLUEVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
     && colorSensor.blue()<Constants.ColorSensorConstants.BLUENECTAR_BLUEVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
      if (colorSensor.red()>Constants.ColorSensorConstants.BLUENECTAR_REDVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
           && colorSensor.red()<Constants.ColorSensorConstants.BLUENECTAR_REDVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
            if (colorSensor.green()>Constants.ColorSensorConstants.BLUENECTAR_GREENVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
            && colorSensor.green()<Constants.ColorSensorConstants.BLUENECTAR_GREENVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
                  return true;
            }
      }
    }
    return false;

  }

  public boolean seesRedNectar() {
    if (colorSensor.blue()<Constants.ColorSensorConstants.REDNECTAR_BLUEVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
    && colorSensor.blue()>Constants.ColorSensorConstants.REDNECTAR_BLUEVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
      if (colorSensor.red()<Constants.ColorSensorConstants.REDNECTAR_REDVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
           && colorSensor.red()>Constants.ColorSensorConstants.REDNECTAR_REDVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
            if (colorSensor.green()<Constants.ColorSensorConstants.REDNECTAR_GREENVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
            && colorSensor.green()>Constants.ColorSensorConstants.REDNECTAR_GREENVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
                  return true;
            }
      }
    }
    return false;
  }

  public boolean seesPollen() {
    if (colorSensor.blue()>Constants.ColorSensorConstants.POLLEN_BLUEVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
     && colorSensor.blue()<Constants.ColorSensorConstants.POLLEN_BLUEVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
      if (colorSensor.red()>Constants.ColorSensorConstants.POLLEN_REDVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
           && colorSensor.red()<Constants.ColorSensorConstants.POLLEN_REDVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
            if (colorSensor.green()>Constants.ColorSensorConstants.POLLEN_GREENVALUE-Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE
            && colorSensor.green()<Constants.ColorSensorConstants.POLLEN_GREENVALUE+Constants.ColorSensorConstants.COLOR_SENSOR_TOLERANCE ) {
                  return true;
            }
      }
    }
    return false;
  }

  public boolean seesAnything(){
    if (seesBlueNectar() || seesRedNectar() || seesPollen()) {
      return true;
    }
    return false;
  }
}
