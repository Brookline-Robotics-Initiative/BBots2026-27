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
            c.xPodOffset.set(-4.2657188355453375);
            c.yPodOffset.set(-1.5521617198553612);
            c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
            c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
            c.globalDistanceUnit.set(DistanceUnit.INCH);
            c.offsetUnits.set(DistanceUnit.INCH);
          });

  public static ForesightConfig foresightConfig =
      new ForesightConfig(
          c -> {
            Controller primaryTranslationalForward = Controller.proportional(0.2427365889395569);
            Controller secondaryTranslationalForward = Controller.proportional(0.08968468357205468);
            Controller primaryTranslationalLateral = Controller.proportional(0.41967019818128143);
            Controller secondaryTranslationalLateral = Controller.proportional(0.15505692443376068);

            c.forwardTranslational.set(
                Controller.piecewise(secondaryTranslationalForward)
                    .put(2.5, primaryTranslationalForward));
            c.strafeTranslational.set(
                Controller.piecewise(secondaryTranslationalLateral)
                    .put(2.5, primaryTranslationalLateral));

            c.coast.set(Controller.proportionalFeedforward(0.017857668185542044));
            c.brake.set(Controller.proportionalFeedforward(0.015179017957710737));

            c.headingFeedback.set(Controller.proportional(4.289192285692679));
            c.headingBrakeCoefficients.set(
                Vector2D.cartesian(0.046739422190892076, 0.004804077694330885));

            c.linearBrakeCoefficients.set(Matrix.diag(0.07768892547748447, 0.08122204765223422));
            c.quadraticBrakeCoefficients.set(
                Matrix.diag(0.0010143991734558174, 0.0010343851946256787));

            c.maxAchievableForwardVelocity.set(61.54977925353883);
            c.maxAchievableStrafeVelocity.set(53.07927438629665);
            c.naturalForwardDeceleration.set(30.349247538831143);
            c.naturalStrafeDeceleration.set(55.81393683293969);
          });

  public static Follower createFollower(HardwareMap hardwareMap) {
    return new Follower(
        new PinpointLocalizer(hardwareMap, localizerConfig),
        new Mecanum(hardwareMap, drivetrainConfig),
        new Foresight(foresightConfig));
  }
}
