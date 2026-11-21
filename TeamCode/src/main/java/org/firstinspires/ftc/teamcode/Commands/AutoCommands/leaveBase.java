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

public class leaveBase extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose DriveToShoot;

  // Path chains
  private Path startPointTODriveToShoot;

  public leaveBase(final Follower follower, HardwareMap hw, Telemetry telemetry)
    throws IOException {
    this.follower = follower;

    TurtleTracerReader pp = new TurtleTracerReader(
      "leaveBase.turt",
      hw.appContext
    );

    // Load poses
    startPoint = pp.get("startPoint");
    DriveToShoot = pp.get("DriveToShoot");

    follower.setPose(startPoint);

    buildPaths();

    addCommands(new FollowPathCommand(follower, startPointTODriveToShoot));
  }

  public void buildPaths() {
    startPointTODriveToShoot = line(startPoint, DriveToShoot).linear(
      Math.toRadians(90),
      Math.toRadians(90)
    );
  }
}
