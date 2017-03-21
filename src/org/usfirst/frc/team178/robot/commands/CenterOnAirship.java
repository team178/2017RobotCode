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
	int threshold;
	final double speed = 0.4;

	public CenterOnAirship() {
		requires(Robot.drivetrain);
		drivetrain = Robot.drivetrain;
		threshold = 2;
		camera = Robot.gearCamera;
		requires(Robot.gearCamera);
		
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turn = -.1;
		drivetrain.changeToLoGear();
	}

	// This is what happens when the robot is to center directly on the airship
	// using vision
	protected void execute() {
		double error = camera.getCenterXfromCameraCenterX();// (camera.getBlendedCenterX())													// -
															// (camera.getIMG_WIDTH()
															// / 2);
		if ((Math.abs(error) > threshold) && (Math.abs(error) < 350)) {
			turn = -.0015 * error;
		/*	if ((turn / 2) <= .09 && (turn / 2) >= 0) { //right
				drivetrain.drive(speed + .09, -speed - .09);
			} else if ((turn / 2) >= -.09 && (turn / 2) <= 0) { //left
				drivetrain.drive(-.09, -.09);
			} else {*/
				drivetrain.drive(speed+(turn / 5), -speed+(turn / 5)); //straight
				
			//}
			// System.out.println("CenterX: " + centerX);
		} else if (Math.abs(error) > 300) {
			//System.out.println("WHAT THE ACTUAL HECK IS THIS?????");
		} else {
			drivetrain.drive(0, 0); //don't move
		}
		// print statements for testing & scaling
	//	if (((timeSinceInitialized() * 1000) % 250) <= 20) {
			System.out.println("BlendedCenter: " + camera.getBlendedCenterX());
			System.out.println("Error: " + error);
			System.out.println("Turn: " + turn);
		//}
	}

	// Checks to see if vision was correct
	protected boolean isFinished() {
		if (Math.abs(camera.getCenterXfromCameraCenterX()) < threshold) {// ||
																			// Math.abs(camera.getCenterXfromCameraCenterX())
																			// >
																			// 400)
																			// {
			System.out.println("THRESHOLD END: " + ((camera.getBlendedCenterX()) - (camera.getIMG_WIDTH() / 2)));
			
			return false;
		} else {
			return false;
		}
	}

	// Finishes
	protected void end() {
		drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drivetrain.drive(0, 0);
	}
}