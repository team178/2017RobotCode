
package org.usfirst.frc.team178.robot;

import org.usfirst.frc.team178.robot.commands.DoNothing;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.autocommandgroups.AutoDriveForward;
import org.usfirst.frc.team178.robot.autocommandgroups.AutoGearSequence;
import org.usfirst.frc.team178.robot.autocommandgroups.AutoLightRobot;

import edu.wpi.cscore.UsbCamera;
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
	public static VisionStreamer frontCamera;
	public static LightsSubsystem lights;
	//public static VisionStreamer backCamera;
	

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
		frontCamera = new VisionStreamer("frontCamera", "axis-camera-intake.local");
		lights = new LightsSubsystem();
		//backCamera = new VisionStreamer("backCamera", "10.1.78.109");
		ropeclimber = new RopeClimber();
		  //backCamera = new VisionStreamer("backCamera", "10.1.78.109"); 
	    oi = new OI(); 
	    lidar = new LIDAR(Port.kOnboard); 
	       
	    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0); 
	    camera.setResolution(1920, 1080); 
	    chooser = new SendableChooser<Command>(); 
	    chooser.addObject("AutoDriveForward", new AutoDriveForward()); 
	    chooser.addObject("AutoGearSequence", new AutoGearSequence()); 
		chooser.addObject("LightShow", new DoNothing());
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
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
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
