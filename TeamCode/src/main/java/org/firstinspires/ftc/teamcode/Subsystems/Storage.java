package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Storage extends SubsystemBase {
  private MotorEx storageMotor;

  private final double MAX_VELOCITY = Constants.StorageConstants.STORAGE_MAX_VELOCITY;
  private final double MIN_VELOCITY = 0; // why is it 1 and not 0?

  public Storage(HardwareMap hwMap, Telemetry telemetry) {
    storageMotor =
        new MotorEx(
            hwMap,
            Constants.StorageConstants.STORAGE_ID,
            Constants.StorageConstants.STORAGE_MOTOR_TYPE);
    storageMotor.setRunMode(Motor.RunMode.VelocityControl);
    storageMotor.setInverted(true);
    storageMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
  }

  private void setVelocity(final double velocity) {
    if (Math.abs(velocity) <= MAX_VELOCITY) {
      storageMotor.setVelocity(velocity);
    }
  }

  public double getVelocity() {
    return storageMotor.getVelocity();
  }

  public void store() {
    setVelocity(-1 * Constants.IntakeConstants.INTAKE_VELOCITY);
  }

  public void expel() {
    setVelocity(Constants.IntakeConstants.EXPEL_VELOCITY);
  }

  public void stop() {
    storageMotor.setRunMode(Motor.RunMode.RawPower);
    storageMotor.set(0);
    storageMotor.setRunMode(Motor.RunMode.VelocityControl);
  }
}
