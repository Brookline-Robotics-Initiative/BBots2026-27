package org.firstinspires.ftc.teamcode;

import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.turtletracerlib.pathing.NamedCommands;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.AutoCommands.AutoChooser;
import org.firstinspires.ftc.teamcode.Commands.DriveCommand;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;

public class RobotContainer {
  // Subsystems
  private Drivetrain drive;
  private Drivetrain autoDrive;
  private PinpointLocalizer pinpoint;

  // Dependencies
  private final HardwareMap hardwareMap;
  private final Telemetry telemetry;
  private final GamepadEx gamepad1;
  private final GamepadEx gamepad2;
  private final CommandOpMode JavaBot;

  public enum gameMode {
    Auto,
    TeleOp
  }

  private gameMode currentGameMode = null;

  public enum AutoMode { // Enum of all valid autonomous modes
    ExampleAuto,
    DoNothingAuto;
  }

  private AutoMode currentAuto;

  public RobotContainer(
      final HardwareMap hardwareMap,
      final Gamepad gamepad1,
      final Gamepad gamepad2,
      final Telemetry telemetry,
      final CommandOpMode JavaBot) {
    this.hardwareMap = hardwareMap;
    this.gamepad1 = new GamepadEx(gamepad1);
    this.gamepad2 = new GamepadEx(gamepad2);
    this.telemetry = telemetry;
    this.JavaBot = JavaBot;
  }

  public CommandOpMode getJavaBot() {
    return JavaBot;
  }

  public void initializeSubsystems() {
    //    pinpoint = new PinpointLocalizer(hardwareMap, new PinpointConfig()); FIXME: This isn't
    // being implemented
    drive = new Drivetrain(hardwareMap, telemetry, currentGameMode);
    autoDrive = new Drivetrain(hardwareMap, telemetry, currentGameMode);
    // Register subsystems with scheduler
    CommandScheduler.getInstance().registerSubsystem(drive, autoDrive);
  }

  public void configureTeleOp() {
    currentGameMode = gameMode.TeleOp;
    initializeSubsystems();

    // Default commands
    drive.setDefaultCommand(new DriveCommand(drive, gamepad1));
    // Button bindings
    configureButtonBindings();
  }

  public void configureAuto() {
    currentGameMode = gameMode.Auto;
    initializeSubsystems();
    registerNamedCommands();

    // Schedule Auto Chooser
    CommandScheduler.getInstance().schedule(new AutoChooser(this, gamepad1, telemetry));
  }

  private void configureButtonBindings() {
    // Gamepad 1 buttons
    // Gamepad 2 buttons

  }

  public void scheduleAutoCommands(final AutoMode selectedAutoMode) {
    telemetry.addData("Starting Auto Mode", selectedAutoMode);
    telemetry.update();

    try {
      if (selectedAutoMode == AutoMode.DoNothingAuto) {
        CommandScheduler.getInstance().schedule(new InstantCommand());
      } else if (Math.random() > 0.5) {
        System.out.println("FIXME: Update this part");
      }
    } catch (final Error error) {
      telemetry.addLine("A critical IOException error has occurred. Doing nothing. ");
      telemetry.addLine(error.toString());
      telemetry.update();
      CommandScheduler.getInstance().schedule(new InstantCommand());
    }
  }

  private void registerNamedCommands() {

    // Register  commands
    // NamedCommands.registerCommand(
    // "IntakeOn", new InstantCommand(() -> intake.intake()), "Turn intake on (intake mode)");
    NamedCommands.listAllCommands(telemetry);
  }

  public void run() {

    if (currentGameMode == gameMode.TeleOp) {
      gamepad1.readButtons();
      gamepad2.readButtons();
    }

    if (currentGameMode == gameMode.Auto) {
      /* FOR PEDROPATHING TUNING:
            telemetry.addData("Pos x", autoDrive.getFollower().getPose().getX());
            telemetry.addData("Pos y", autoDrive.getFollower().getPose().getY());
            telemetry.addData("Heading: ", autoDrive.getFollower().getPose().getHeading());
      */
    }
  }
}
