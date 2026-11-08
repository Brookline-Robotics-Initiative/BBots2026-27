package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.CRServo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class StorageServo extends SubsystemBase {
  private static CRServo storageServo;
  private static Telemetry telemetry;

  public StorageServo(HardwareMap hwMap, Telemetry telemetry) {
    storageServo = new CRServo(hwMap, Constants.StorageServoConstants.STORAGE_SERVO_ID);
    this.telemetry = telemetry;
  }

  private static void setPower(final double power) {
    storageServo.set(power);
  }

  public static double getPower() {
    return storageServo.get();
  }

  public void intake() {
    storageServo.setInverted(false);
    setPower(Constants.StorageServoConstants.STORAGE_SERVO_INTAKE_POWER);
    telemetry.addData("Power:", getPower());
    telemetry.update();
  }

  public void expel() {
    storageServo.setInverted(true);
    setPower(Constants.StorageServoConstants.STORAGE_SERVO_INTAKE_POWER);
    telemetry.addData("Power:", getPower());
    telemetry.update();
  }

  public void stop() {
    setPower(0);
  }
}
