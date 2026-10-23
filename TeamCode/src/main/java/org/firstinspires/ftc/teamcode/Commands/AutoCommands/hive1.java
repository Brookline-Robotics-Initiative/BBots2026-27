/* ============================================================= *
 *                 Turtle Tracer — Auto-Generated                *
 *                                                               *
 *  Version: 2.5.1.                                              *
 *  Copyright (c) 2026 Matthew Allen                             *
 *                                                               *
 *  THIS FILE IS AUTO-GENERATED — DO NOT EDIT MANUALLY.          *
 *  Changes will be overwritten when regenerated.                *
 * ============================================================= */

package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
import static com.pedropathing.api.Paths.path;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.interpolator.Interpolator;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.ParallelRaceGroup;
import com.seattlesolvers.solverslib.command.RunCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;
import com.turtletracerlib.TurtleTracerReader;
import com.turtletracerlib.pathing.NamedCommands;
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

  public hive1(final Follower follower, HardwareMap hw, Telemetry telemetry)
    throws IOException {
    this.follower = follower;

    TurtleTracerReader pp = new TurtleTracerReader("hive1.turt", hw.appContext);

    // Load poses
    startPoint = pp.get("startPoint");
    DriveToShoot = pp.get("DriveToShoot");
    IntakeGarden = pp.get("IntakeGarden");
    IntakeGarden_line1_control1 = pp.get("IntakeGarden_line1_control1");
    GardenBackUp = pp.get("GardenBackUp");
    GardenToShoot = pp.get("GardenToShoot");
    ShootToPark = pp.get("ShootToPark");
    ShootToPark_line4_control1 = pp.get("ShootToPark_line4_control1");

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
      new FollowPathCommand(follower, GardenToShootTOShootToPark)
    );
  }

  public void buildPaths() {
    startPointTODriveToShoot = line(startPoint, DriveToShoot).linear(
      Math.toRadians(90),
      Math.toRadians(90)
    );

    DriveToShootTOIntakeGarden = curve(
      DriveToShoot,
      p.of(10.750, 42.373, 0.0),
      IntakeGarden
    ).linear(Math.toRadians(-90), Math.toRadians(-90));

    IntakeGardenTOGardenBackUp = line(IntakeGarden, GardenBackUp).linear(
      Math.toRadians(-90),
      Math.toRadians(-90)
    );

    GardenBackUpTOGardenToShoot = line(GardenBackUp, GardenToShoot).linear(
      Math.toRadians(-90),
      Math.toRadians(90)
    );

    GardenToShootTOShootToPark = curve(
      GardenToShoot,
      p.of(9.116, 29.427, 0.0),
      ShootToPark
    ).tangent();
  }
}
