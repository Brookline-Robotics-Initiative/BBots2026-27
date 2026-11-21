package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Outtake extends SubsystemBase {
  private final MotorEx outtakeMotor;
  private final Motor.Encoder encoder;
  private final double MAX_VELOCITY = Constants.OuttakeConstants.OUTTAKE_MAX_VELOCITY;
  private final double MIN_VELOCITY = 1;
  private final int RESET_POSITION = Constants.OuttakeConstants.OUTTAKE_START_POSITION;
  private int lastShootPosition = 0;
  private final double tolerance = 10; // TUNE
  // private boolean isMovingToTarget = false;

  private double targetPosition = 0;

  public Telemetry telemetry;

  private final PIDFController pidf;

  public Outtake(final HardwareMap hwMap, final Telemetry telemetry) {
    this.telemetry = telemetry;
    outtakeMotor =
        new MotorEx(
            hwMap,
            Constants.OuttakeConstants.OUTTAKE_ID,
            Motor.GoBILDA.BARE); // TODO add motor type
    encoder = outtakeMotor.encoder;
    outtakeMotor.setRunMode(
        Motor.RunMode
            .RawPower); // keep track of the encoder position and do control loop -- control loop
    // runs with pid and tuning is manual
    // outtakeMotor.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    // outtakeMotor.setBuffer(0.8); // will get higher later
    pidf = new PIDFController(0.005, 0.0, 0.0025, 0.00036); // TUNE
    lastShootPosition = outtakeMotor.getCurrentPosition();
    outtakeMotor.setInverted(true);
  }

  /*public void setVelocity(final double velocity) {
    if (velocity >= MIN_VELOCITY && velocity <= MAX_VELOCITY) {
      outtakeMotor.setVelocity(velocity);
    }
  }*/

  public void setPosition() {
    targetPosition =
        pidf.calculate(
            outtakeMotor.getCurrentPosition(), Constants.OuttakeConstants.OUTTAKE_POSITION);
  }

  public boolean atPosition() {
    return outtakeMotor.atTargetPosition();
  }

  // rotations measures what direction and how far the outtake paddle
  public boolean isPassed(double rotations) {
    // should move
    return (outtakeMotor.getCurrentPosition()
        >= (lastShootPosition + outtakeMotor.getCPR() * rotations));
  }

  public int getPosition() {
    return outtakeMotor.getCurrentPosition();
  }

  public void shoot() {
    lastShootPosition = outtakeMotor.getCurrentPosition();
    outtakeMotor.setVelocity(MAX_VELOCITY * 0.9);
  }

  //    public void resetToStartPosition(){
  //        //FIXME Matthew is worried we are doing math that doesn't make sense to do
  //        int currentPos = (int)(outtakeMotor.getCurrentPosition()/(encoder.getRevolutions() *
  // outtakeMotor.getCPR()));
  //
  //
  //        //FIXME I don't feel that confident in the PID controller stuff so please check over
  //        while (!pidf.atSetPoint()) {
  //            double output = pidf.calculate(currentPos, RESET_POSITION);
  //            outtakeMotor.setVelocity(output);
  //        }
  //        outtakeMotor.stopMotor();
  //    }
  @Override
  public void periodic() {
    telemetry.addData("outtake position", outtakeMotor.getCurrentPosition());
    telemetry.addData("outtake power", outtakeMotor.get());
    telemetry.update();
  }

  public void stop() {
    outtakeMotor.set(0);
  }
}
