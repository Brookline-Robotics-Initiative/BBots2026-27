/* ============================================================= *
 *                 Turtle Tracer — Auto-Generated                *
 *                                                               *
 *  Version: 2.6.1.                                              *
 *  Copyright (c) 2026 Matthew Allen                             *
 *                                                               *
 *  THIS FILE IS AUTO-GENERATED — DO NOT EDIT MANUALLY.          *
 *  Changes will be overwritten when regenerated.                *
 * ============================================================= */

package org.firstinspires.ftc.teamcode.Commands.AutoCommands;

import static com.pedropathing.api.Paths.line;
import static com.pedropathing.api.Paths.path;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.SequentialCommandGroup;
import com.seattlesolvers.solverslib.command.WaitCommand;
import com.seattlesolvers.solverslib.command.WaitUntilCommand;
import com.seattlesolvers.solverslib.pedroCommand.FollowPathCommand;
import java.io.IOException;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetryCalibration extends SequentialCommandGroup {

  private final Follower follower;
  private final PoseFactory p = PoseFactory.degrees();

  // Poses
  private Pose startPoint;
  private Pose Forward1;
  private Pose Forward2;
  private Pose Forward3;
  private Pose Forward4;
  private Pose Forward5;
  private Pose Forward6;
  private Pose Corner1run;
  private Pose Corner1corner;
  private Pose Corner2run;
  private Pose Corner2corner;
  private Pose Corner3run;
  private Pose Corner3corner;
  private Pose Corner4run;
  private Pose Corner4corner;
  private Pose Corner5run;
  private Pose Corner5corner;
  private Pose Corner6run;
  private Pose Corner6corner;
  private Pose Corner7run;
  private Pose Corner7corner;
  private Pose Corner8run;
  private Pose Corner8corner;
  private Pose Corner9run;
  private Pose Corner9corner;
  private Pose Corner10run;
  private Pose Corner10corner;
  private Pose Corner11run;
  private Pose Corner11corner;
  private Pose Corner12run;
  private Pose Corner12corner;
  private Pose Strafe1;
  private Pose Strafe2;
  private Pose Strafe3;
  private Pose Strafe4;
  private Pose Strafe5;
  private Pose Strafe6;

  // Path chains
  private Path startPointTOForward1;
  private Path Forward1TOForward2;
  private Path Forward2TOForward3;
  private Path Forward3TOForward4;
  private Path Forward4TOForward5;
  private Path Forward5TOForward6;
  private Path Forward6TOCorner1run;
  private Path Corner1cornerTOCorner2run;
  private Path Corner2cornerTOCorner3run;
  private Path Corner3cornerTOCorner4run;
  private Path Corner4cornerTOCorner5run;
  private Path Corner5cornerTOCorner6run;
  private Path Corner6cornerTOCorner7run;
  private Path Corner7cornerTOCorner8run;
  private Path Corner8cornerTOCorner9run;
  private Path Corner9cornerTOCorner10run;
  private Path Corner10cornerTOCorner11run;
  private Path Corner11cornerTOCorner12run;
  private Path Corner12cornerTOStrafe1;
  private Path Strafe1TOStrafe2;
  private Path Strafe2TOStrafe3;
  private Path Strafe3TOStrafe4;
  private Path Strafe4TOStrafe5;
  private Path Strafe5TOStrafe6;

  public TelemetryCalibration(final Follower follower, HardwareMap hw, Telemetry telemetry)
      throws IOException {
    this.follower = follower;

    // Load poses
    startPoint = p.of(12.000, 24.000, 0);
    Forward1 = p.of(132.000, 24.000, 0);
    Forward2 = p.of(12.000, 24.000, 0);
    Forward3 = p.of(132.000, 24.000, 0);
    Forward4 = p.of(12.000, 24.000, 0);
    Forward5 = p.of(132.000, 24.000, 0);
    Forward6 = p.of(12.000, 24.000, 0);
    Corner1run = p.of(116.000, 24.000, 0);
    Corner1corner = p.of(116.000, 54.000, 0);
    Corner2run = p.of(116.000, 112.000, 0);
    Corner2corner = p.of(86.000, 112.000, 0);
    Corner3run = p.of(28.000, 112.000, 0);
    Corner3corner = p.of(28.000, 82.000, 0);
    Corner4run = p.of(28.000, 24.000, 0);
    Corner4corner = p.of(58.000, 24.000, 0);
    Corner5run = p.of(116.000, 24.000, 0);
    Corner5corner = p.of(116.000, 54.000, 0);
    Corner6run = p.of(116.000, 112.000, 0);
    Corner6corner = p.of(86.000, 112.000, 0);
    Corner7run = p.of(28.000, 112.000, 0);
    Corner7corner = p.of(28.000, 82.000, 0);
    Corner8run = p.of(28.000, 24.000, 0);
    Corner8corner = p.of(58.000, 24.000, 0);
    Corner9run = p.of(116.000, 24.000, 0);
    Corner9corner = p.of(116.000, 54.000, 0);
    Corner10run = p.of(116.000, 112.000, 0);
    Corner10corner = p.of(86.000, 112.000, 0);
    Corner11run = p.of(28.000, 112.000, 0);
    Corner11corner = p.of(28.000, 82.000, 0);
    Corner12run = p.of(28.000, 24.000, 0);
    Corner12corner = p.of(58.000, 24.000, 0);
    Strafe1 = p.of(132.000, 24.000, 90);
    Strafe2 = p.of(12.000, 24.000, 90);
    Strafe3 = p.of(132.000, 24.000, 90);
    Strafe4 = p.of(12.000, 24.000, 90);
    Strafe5 = p.of(132.000, 24.000, 90);
    Strafe6 = p.of(12.000, 24.000, 90);

    follower.setPose(startPoint);

    buildPaths();

    addCommands(
        new WaitCommand(1500),
        new FollowPathCommand(follower, startPointTOForward1),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward1TOForward2),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward2TOForward3),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward3TOForward4),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward4TOForward5),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward5TOForward6),
        new WaitCommand(500),
        new FollowPathCommand(follower, Forward6TOCorner1run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner1cornerTOCorner2run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner2cornerTOCorner3run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner3cornerTOCorner4run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner4cornerTOCorner5run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner5cornerTOCorner6run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner6cornerTOCorner7run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner7cornerTOCorner8run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner8cornerTOCorner9run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner9cornerTOCorner10run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner10cornerTOCorner11run),
        new WaitCommand(500),
        new FollowPathCommand(follower, Corner11cornerTOCorner12run),
        new WaitCommand(500),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(3.142));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 3.142))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(0.000));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 0.000))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(3.142));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 3.142))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(0.000));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 0.000))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(3.142));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 3.142))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(0.000));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 0.000))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(3.142));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 3.142))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(0.000));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 0.000))
                    < 0.01),
        new WaitCommand(300),
        new InstantCommand(
            () -> {
              follower.hold(follower.pose().withHeading(1.571));
              follower.algorithm().reset();
            }),
        new WaitUntilCommand(
            () ->
                Math.abs(com.pedropathing.utils.Angle.error(follower.pose().heading(), 1.571))
                    < 0.01),
        new WaitCommand(300),
        new FollowPathCommand(follower, Corner12cornerTOStrafe1),
        new WaitCommand(500),
        new FollowPathCommand(follower, Strafe1TOStrafe2),
        new WaitCommand(500),
        new FollowPathCommand(follower, Strafe2TOStrafe3),
        new WaitCommand(500),
        new FollowPathCommand(follower, Strafe3TOStrafe4),
        new WaitCommand(500),
        new FollowPathCommand(follower, Strafe4TOStrafe5),
        new WaitCommand(500),
        new FollowPathCommand(follower, Strafe5TOStrafe6),
        new WaitCommand(500));
  }

  public void buildPaths() {
    startPointTOForward1 = line(startPoint, Forward1).constant(Math.toRadians(0));

    Forward1TOForward2 = line(Forward1, Forward2).constant(Math.toRadians(0));

    Forward2TOForward3 = line(Forward2, Forward3).constant(Math.toRadians(0));

    Forward3TOForward4 = line(Forward3, Forward4).constant(Math.toRadians(0));

    Forward4TOForward5 = line(Forward4, Forward5).constant(Math.toRadians(0));

    Forward5TOForward6 = line(Forward5, Forward6).constant(Math.toRadians(0));

    Forward6TOCorner1run =
        path(
            line(Forward6, Corner1run).constant(Math.toRadians(0)),
            line(Corner1run, Corner1corner).constant(Math.toRadians(0)));

    Corner1cornerTOCorner2run =
        path(
            line(Corner1corner, Corner2run).constant(Math.toRadians(0)),
            line(Corner2run, Corner2corner).constant(Math.toRadians(0)));

    Corner2cornerTOCorner3run =
        path(
            line(Corner2corner, Corner3run).constant(Math.toRadians(0)),
            line(Corner3run, Corner3corner).constant(Math.toRadians(0)));

    Corner3cornerTOCorner4run =
        path(
            line(Corner3corner, Corner4run).constant(Math.toRadians(0)),
            line(Corner4run, Corner4corner).constant(Math.toRadians(0)));

    Corner4cornerTOCorner5run =
        path(
            line(Corner4corner, Corner5run).constant(Math.toRadians(0)),
            line(Corner5run, Corner5corner).constant(Math.toRadians(0)));

    Corner5cornerTOCorner6run =
        path(
            line(Corner5corner, Corner6run).constant(Math.toRadians(0)),
            line(Corner6run, Corner6corner).constant(Math.toRadians(0)));

    Corner6cornerTOCorner7run =
        path(
            line(Corner6corner, Corner7run).constant(Math.toRadians(0)),
            line(Corner7run, Corner7corner).constant(Math.toRadians(0)));

    Corner7cornerTOCorner8run =
        path(
            line(Corner7corner, Corner8run).constant(Math.toRadians(0)),
            line(Corner8run, Corner8corner).constant(Math.toRadians(0)));

    Corner8cornerTOCorner9run =
        path(
            line(Corner8corner, Corner9run).constant(Math.toRadians(0)),
            line(Corner9run, Corner9corner).constant(Math.toRadians(0)));

    Corner9cornerTOCorner10run =
        path(
            line(Corner9corner, Corner10run).constant(Math.toRadians(0)),
            line(Corner10run, Corner10corner).constant(Math.toRadians(0)));

    Corner10cornerTOCorner11run =
        path(
            line(Corner10corner, Corner11run).constant(Math.toRadians(0)),
            line(Corner11run, Corner11corner).constant(Math.toRadians(0)));

    Corner11cornerTOCorner12run =
        path(
            line(Corner11corner, Corner12run).constant(Math.toRadians(0)),
            line(Corner12run, Corner12corner).constant(Math.toRadians(0)));

    Corner12cornerTOStrafe1 = line(Corner12corner, Strafe1).constant(Math.toRadians(90));

    Strafe1TOStrafe2 = line(Strafe1, Strafe2).constant(Math.toRadians(90));

    Strafe2TOStrafe3 = line(Strafe2, Strafe3).constant(Math.toRadians(90));

    Strafe3TOStrafe4 = line(Strafe3, Strafe4).constant(Math.toRadians(90));

    Strafe4TOStrafe5 = line(Strafe4, Strafe5).constant(Math.toRadians(90));

    Strafe5TOStrafe6 = line(Strafe5, Strafe6).constant(Math.toRadians(90));
  }
}
