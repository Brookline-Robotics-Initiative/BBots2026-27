/* ============================================================= *
 *                 Turtle Tracer — Auto-Generated                *
 *                                                               *
 *  Version: 2.7.0.                                              *
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
import com.turtletracerlib.auto.TurtleAuto;
import java.io.IOException;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TurtleAuto(name = "leaveBaseBackWall")
public class leaveBaseBackWall extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose moveAwayFromWall;

  // Path chains
  private Path startPointTOmoveAwayFromWall;

  public leaveBaseBackWall(
    final Follower follower,
    HardwareMap hw,
    Telemetry telemetry
  ) throws IOException {
    this.follower = follower;

    TurtleTracerReader pp = new TurtleTracerReader(
      "leaveBaseBackWall.turt",
      hw.appContext
    );

    // Load poses
    startPoint = pp.get("startPoint");
    moveAwayFromWall = pp.get("moveAwayFromWall");

    follower.setPose(startPoint);

    buildPaths();

    addCommands(new FollowPathCommand(follower, startPointTOmoveAwayFromWall));
  }

  public void buildPaths() {
    startPointTOmoveAwayFromWall = line(startPoint, moveAwayFromWall).linear(
      Math.toRadians(0),
      Math.toRadians(0)
    );
  }
}
