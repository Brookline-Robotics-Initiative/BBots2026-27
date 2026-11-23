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

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;
import java.io.IOException;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class leaveBaseFrontBlueWall extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose moveawayfromfrontwallblue;

  // Path chains
  private Path startPointTOmoveawayfromfrontwallblue;

  public leaveBaseFrontBlueWall(final Follower follower, HardwareMap hw, Telemetry telemetry)
      throws IOException {
    this.follower = follower;

    // Load poses
    startPoint = p.of(108.000, 134.700, 0);
    moveawayfromfrontwallblue = p.of(108.000, 113.000, 0);

    follower.setPose(startPoint);

    buildPaths();

    addCommands(new FollowPathCommand(follower, startPointTOmoveawayfromfrontwallblue));
  }

  public void buildPaths() {
    startPointTOmoveawayfromfrontwallblue =
        line(startPoint, moveawayfromfrontwallblue).linear(Math.toRadians(0), Math.toRadians(0));
  }
}
