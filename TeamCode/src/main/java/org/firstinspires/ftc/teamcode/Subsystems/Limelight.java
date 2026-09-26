package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class Limelight extends SubsystemBase {

  private Limelight3A limelight;
  private LLResult latestResult;

  public Limelight(HardwareMap hardwareMap) {
    limelight = hardwareMap.get(Limelight3A.class, "limeight");
    limelight.setPollRateHz(100);
    limelight.pipelineSwitch(0);
    limelight.start();
  }

  @Override
  public void periodic() {
    latestResult = limelight.getLatestResult();
  }

  public double getDistance() {
    if (latestResult != null && latestResult.isValid()) {
      return getDistanceFromTag(latestResult.getTa());
    }
    return -1;
  }

  public double getTx() {
    if (latestResult != null && latestResult.isValid()) {
      return latestResult.getTx();
    }
    return 0;
  }

  public double getTy() {
    if (latestResult != null && latestResult.isValid()) {
      return latestResult.getTy();
    }
    return 0;
  }

  public double getTa() {
    if (latestResult != null && latestResult.isValid()) {
      return latestResult.getTa();
    }
    return 0;
  }

  public boolean hasTarget() {
    return latestResult != null && latestResult.isValid();
  }

  private double getDistanceFromTag(double ta) {
    double scale = 400; // TODO: Calibrate this (once mounted on the robot)
    double distance = (scale / ta);
    return distance;
  }
}
