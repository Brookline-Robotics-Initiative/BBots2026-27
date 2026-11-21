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

@TurtleAuto(name = "leaveBaseFrontBlueWall")
public class leaveBaseFrontBlueWall extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose moveawayfromfrontwallblue;

  // Path chains
  private Path startPointTOmoveawayfromfrontwallblue;

  public leaveBaseFrontBlueWall(
    final Follower follower,
    HardwareMap hw,
    Telemetry telemetry
  ) throws IOException {
    this.follower = follower;

    TurtleTracerReader pp = new TurtleTracerReader(
      "leaveBaseFrontBlueWall.turt",
      hw.appContext
    );

    // Load poses
    startPoint = pp.get("startPoint");
    moveawayfromfrontwallblue = pp.get("moveawayfromfrontwallblue");

    follower.setPose(startPoint);

    buildPaths();

    addCommands(
      new FollowPathCommand(follower, startPointTOmoveawayfromfrontwallblue)
    );
  }

  public void buildPaths() {
    startPointTOmoveawayfromfrontwallblue = line(
      startPoint,
      moveawayfromfrontwallblue
    ).linear(Math.toRadians(0), Math.toRadians(0));
  }
}
