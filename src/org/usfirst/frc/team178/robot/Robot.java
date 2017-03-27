
package org.usfirst.frc.team178.robot;

//import org.usfirst.frc.team178.robot.commands.DoNothing;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.LIDARDistance;
import org.usfirst.frc.team178.robot.commands.PauseRobot;
import org.usfirst.frc.team178.robot.commands.SetDefaultLights;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.autocommandgroups.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static LIDAR lidar;
	public static DriveTrain drivetrain;
	public static Pneumatics pneumatics;
	public static GearGobbler geargobbler;
	public static BallSweeper ballsweeper;
	public static RopeClimber ropeclimber;
	public static FuelShooter fuelshooter;
	public static VisionStreamer gearCamera;
	public static LightsSubsystem lights;
	public static AnalogGyro gyro;
	public static VisionStreamer shooterCamera;

	Command autonomousCommand;
	SendableChooser<Command> chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new DriveTrain();
		pneumatics = new Pneumatics();
		geargobbler = new GearGobbler();
		ballsweeper = new BallSweeper();
		fuelshooter = new FuelShooter();
		gearCamera = new VisionStreamer("gearCamera", "10.1.78.11");
		lights = new LightsSubsystem();
	//	shooterCamera = new VisionStreamer("shooterCamera", "178-shooter-camera.local");
		ropeclimber = new RopeClimber();
		lidar = new LIDAR(Port.kOnboard);
		gyro = new AnalogGyro(RobotMap.GYRO);

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
		camera.setResolution(400, 200);

		oi = new OI(); // NEEDS to be after subsystems

		chooser = new SendableChooser<Command>();
		chooser.addObject("AutoDriveForward", new AutoDriveForward());
		chooser.addObject("AutoGear Left (1)", new AutoGearSequenceLeft());
		chooser.addObject("AutoGear Middle (2)", new AutoGearSequenceMiddle());
		chooser.addObject("AutoGear Right (3)", new AutoGearSequenceRight());
		chooser.addObject("Do Nothing", new PauseRobot(15));
		chooser.addObject("AutoGear w/ Delay, right (RED ALLIANCE)", new AutoGearRightDelay());
		chooser.addObject("AutoGear w/ Delay, left (BLUE ALLIANCE)", new AutoGearLeftDelay());
		chooser.addObject("Do both (LEFT SIDE)", new AutoDoubleSequenceLeft());
		chooser.addObject("Do both (RIGHT SIDE)", new AutoDoubleSequenceRight());
		chooser.addObject("Sit and Shoot (RED ALLIANCE)", new AutoSitAndShootRed());
		chooser.addObject("Sit and Shoot (BLUE ALLIANCE)", new AutoSitAndShootBlue());
		chooser.addObject("Shoot then Gear (RED ALLIANCE)", new AutoSitShootGearRed());
		chooser.addObject("Shoot then Gear (BLUE ALLIANCE)", new AutoSitShootGearBlue());
		chooser.addObject("Light Show (sit there and light)", new AutoLightRobot());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) 
			autonomousCommand.cancel();
		drivetrain.changeToHiGear();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Distance GearGobbler: ", geargobbler.getDistanceGG());
		SmartDashboard.putNumber("Distance DriveTrain", drivetrain.getDistanceDT());
		SmartDashboard.putNumber("Pressure", pneumatics.getPressure());
		//SmartDashboard.putBoolean("Gear in gobbler: ", geargobbler.getToggled());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {

		LiveWindow.run();
	}
}
