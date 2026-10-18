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
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeftMotor");
        c.frontRightName.set("frontRightMotor");
        c.backLeftName.set("backLeftMotor");
        c.backRightName.set("backRightMotor");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        c.xPodOffset.set(-5.039054690383551);
        c.yPodOffset.set(-3.465088671586645);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.6918084646366569);
                Controller secondaryTranslationalForward = Controller.proportional(0.25560474222061796);
                Controller primaryTranslationalLateral = Controller.proportional(1.306824012460313);
                Controller secondaryTranslationalLateral = Controller.proportional(0.48283655362336064);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.016377658886732496));
                c.brake.set(Controller.proportionalFeedforward(0.013921010053722621));

                c.headingFeedback.set(Controller.proportional(4.279777681405689));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.043922941316168515, 0.005377696636793645));

                c.linearBrakeCoefficients.set(Matrix.diag(0.0450653162639568, 0.04401223598329838));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.002017859860966682, 0.0016049569428496324));

                c.maxAchievableForwardVelocity.set(62.6321833988067);
                c.maxAchievableStrafeVelocity.set(55.24797429320508);
                c.naturalForwardDeceleration.set(43.19459872999997);
                c.naturalStrafeDeceleration.set(51.59615090010216);
            }
    );

  public static Follower createFollower(HardwareMap hardwareMap) {
    return new Follower(
        new PinpointLocalizer(hardwareMap, localizerConfig),
        new Mecanum(hardwareMap, drivetrainConfig),
        new Foresight(foresightConfig));
  }
}
