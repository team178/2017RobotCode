package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.VisionStreamer;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnAirship extends Command {

	private final Object imgLock = new Object();
	DriveTrain drivetrain;
	VisionStreamer camera;
	double turn;

	public CenterOnAirship() {
		requires(Robot.drivetrain);
		drivetrain = Robot.drivetrain;
		requires(Robot.frontCamera);
		camera = Robot.frontCamera;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turn = -.1;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double centerX;
		synchronized (imgLock) {
			centerX = camera.getTapeCenterX();
		}
		double error = centerX - (camera.getIMG_WIDTH() / 2);
		System.out.println("Error: " + error);
		if (Math.abs(error) > .5) {
			turn += .00001 * error;
			drivetrain.drive(0.1, turn);
			System.out.println("Turn: " + turn);
			System.out.println("CenterX: " + centerX);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(camera.getCenterXfromCameraCenterX()) < .5) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
