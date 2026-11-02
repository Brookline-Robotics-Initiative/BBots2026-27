package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Pedro Pathing 3.0 constants. The values below are placeholders: run the AutoTune procedures in
 * {@link Tuning} (see https://pedropathing.com/docs/pathing/tuning) and paste the generated configs
 * here. If you use a different drivetrain or localizer, swap the config classes and {@link
 * #createFollower} to match.
 */
public class Constants {

  public static MecanumConfig drivetrainConfig =
      new MecanumConfig(
          c -> {
            c.frontLeftName.set("frontLeftMotor");
            c.frontRightName.set("frontRightMotor");
            c.backLeftName.set("backLeftMotor");
            c.backRightName.set("backRightMotor");
            c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
            c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
            c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
            c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
          });

  public static PinpointConfig localizerConfig =
      new PinpointConfig(
          c -> {
            c.name.set("pinpoint");
            c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
            c.xPodOffset.set(-2.8475147157203495);
            c.yPodOffset.set(-0.6686829394242895);
            c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
            c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
            c.globalDistanceUnit.set(DistanceUnit.INCH);
            c.offsetUnits.set(DistanceUnit.INCH);
          });

  public static ForesightConfig foresightConfig =
      new ForesightConfig(
          c -> {
            Controller primaryTranslationalForward = Controller.proportional(0.17923062042620694);
            Controller secondaryTranslationalForward = Controller.proportional(0.066220925117103);
            Controller primaryTranslationalLateral = Controller.proportional(0.7670058307328426);
            Controller secondaryTranslationalLateral = Controller.proportional(0.28338815968253056);

            c.forwardTranslational.set(
                Controller.piecewise(secondaryTranslationalForward)
                    .put(2.5, primaryTranslationalForward));
            c.strafeTranslational.set(
                Controller.piecewise(secondaryTranslationalLateral)
                    .put(2.5, primaryTranslationalLateral));

            c.coast.set(Controller.proportionalFeedforward(0.016919671350309713));
            c.brake.set(Controller.proportionalFeedforward(0.014381720647763255));

            c.headingFeedback.set(Controller.proportional(4.379845748003454));
            c.headingBrakeCoefficients.set(
                Vector2D.cartesian(0.04682780460651889, 0.0037412062420743844));

            c.linearBrakeCoefficients.set(Matrix.diag(0.0616224988455464, 0.026735759680192154));
            c.quadraticBrakeCoefficients.set(
                Matrix.diag(0.0010646823877706853, 0.002160322813815302));

            c.maxAchievableForwardVelocity.set(64.0794565446379);
            c.maxAchievableStrafeVelocity.set(53.77643162851285);
            c.naturalForwardDeceleration.set(36.48560086591593);
            c.naturalStrafeDeceleration.set(58.839589074964756);
          });

  public static Follower createFollower(HardwareMap hardwareMap) {
    return new Follower(
        new PinpointLocalizer(hardwareMap, localizerConfig),
        new Mecanum(hardwareMap, drivetrainConfig),
        new Foresight(foresightConfig));
  }
}
