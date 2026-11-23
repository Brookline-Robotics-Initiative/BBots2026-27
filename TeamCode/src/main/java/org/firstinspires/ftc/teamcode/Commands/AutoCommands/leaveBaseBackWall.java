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

public class leaveBaseBackWall extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose moveAwayFromWall;

  // Path chains
  private Path startPointTOmoveAwayFromWall;

  public leaveBaseBackWall(final Follower follower, HardwareMap hw, Telemetry telemetry)
      throws IOException {
    this.follower = follower;

    // Load poses
    startPoint = p.of(36.000, 9.500, 0);
    moveAwayFromWall = p.of(36.000, 20.000, 0);

    follower.setPose(startPoint);

    buildPaths();

    addCommands(new FollowPathCommand(follower, startPointTOmoveAwayFromWall));
  }

  public void buildPaths() {
    startPointTOmoveAwayFromWall =
        line(startPoint, moveAwayFromWall).linear(Math.toRadians(0), Math.toRadians(0));
  }
}
