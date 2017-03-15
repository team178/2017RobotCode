package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.VisionStreamer;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnBoiler extends Command {

	private final Object imgLock = new Object();
	DriveTrain drivetrain;
	VisionStreamer camera;
	double drive;
	double driveYValue;
	int thresholdX;
	int thresholdY;
	final double speed = 0.2;

	public CenterOnBoiler() {
		requires(Robot.drivetrain);
		drivetrain = Robot.drivetrain;
		thresholdX = 50;
		thresholdY = 272;
		camera = Robot.shooterCamera;
		requires(Robot.shooterCamera);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drive = -.2;
		driveYValue = -.1;
		drivetrain.changeToLoGear();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double xError = camera.getCenterXfromCameraCenterX();
		 if ((Math.abs(xError) > thresholdX) && (Math.abs(xError) < 350)) {
			drive = -.0015 * xError;
			drivetrain.correctSpeed(drive /4, drive/4);
			System.out.println(xError);
		} else {
			drivetrain.drive(0, 0); // don't move
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(camera.getCenterXfromCameraCenterX()) <= thresholdX) {
			System.out.println("THRESHOLD END: " + ((camera.getBlendedCenterY()) - (camera.getIMG_HEIGHT() / 2)));
			drivetrain.drive(0, 0);
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("Finished");
		drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drivetrain.drive(0, 0);
	}
}
