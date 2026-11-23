/* ============================================================= *
 *                 Turtle Tracer — Auto-Generated                *
 *                                                               *
 *  Version: 2.5.0.                                              *
 *  Copyright (c) 2026 Matthew Allen                             *
 *                                                               *
 *  THIS FILE IS AUTO-GENERATED — DO NOT EDIT MANUALLY.          *
 *  Changes will be overwritten when regenerated.                *
 * ============================================================= */

package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;
import java.io.IOException;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class hive1 extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose DriveToShoot;
  private Pose IntakeGarden;
  private Pose IntakeGarden_line1_control1;
  private Pose GardenBackUp;
  private Pose GardenToShoot;
  private Pose ShootToPark;
  private Pose ShootToPark_line4_control1;

  // Path chains
  private Path startPointTODriveToShoot;
  private Path DriveToShootTOIntakeGarden;
  private Path IntakeGardenTOGardenBackUp;
  private Path GardenBackUpTOGardenToShoot;
  private Path GardenToShootTOShootToPark;

  public hive1(final Follower follower, HardwareMap hw, Telemetry telemetry) throws IOException {
    this.follower = follower;

    // Load poses
    startPoint = p.of(60.000, 9.602, 90);
    DriveToShoot = p.of(60.000, 34.476, 90);
    IntakeGarden = p.of(10.750, 13.057, -90);
    IntakeGarden_line1_control1 = p.of(10.750, 42.373, 0.0);
    GardenBackUp = p.of(10.750, 34.476, -90);
    GardenToShoot = p.of(60.000, 34.476, 90);
    ShootToPark = p.of(13.570, 104.439, 0);
    ShootToPark_line4_control1 = p.of(9.116, 29.427, 0.0);

    follower.setPose(startPoint);

    buildPaths();

    addCommands(
        new FollowPathCommand(follower, startPointTODriveToShoot),
        new WaitCommand(4000),
        new FollowPathCommand(follower, DriveToShootTOIntakeGarden),
        new WaitCommand(500),
        new FollowPathCommand(follower, IntakeGardenTOGardenBackUp),
        new FollowPathCommand(follower, GardenBackUpTOGardenToShoot),
        new WaitCommand(2000),
        new FollowPathCommand(follower, GardenToShootTOShootToPark));
  }

  public void buildPaths() {
    startPointTODriveToShoot =
        line(startPoint, DriveToShoot).linear(Math.toRadians(90), Math.toRadians(90));

    DriveToShootTOIntakeGarden =
        curve(DriveToShoot, p.of(10.750, 42.373, 0.0), IntakeGarden)
            .linear(Math.toRadians(-90), Math.toRadians(-90));

    IntakeGardenTOGardenBackUp =
        line(IntakeGarden, GardenBackUp).linear(Math.toRadians(-90), Math.toRadians(-90));

    GardenBackUpTOGardenToShoot =
        line(GardenBackUp, GardenToShoot).linear(Math.toRadians(-90), Math.toRadians(90));

    GardenToShootTOShootToPark =
        curve(GardenToShoot, p.of(9.116, 29.427, 0.0), ShootToPark).tangent();
  }
}
