package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class DriveDistance extends Command {
	OI oi;
	DriveTrain drivetrain;
	double distance;
	double adjustedSpeed;
	double robotSpeed;

	public DriveDistance(double dist, double speed) {
		requires(Robot.drivetrain);
		distance = dist;
		robotSpeed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = Robot.oi;
		drivetrain = Robot.drivetrain;
		drivetrain.resetEncoders();
		adjustedSpeed = -robotSpeed;
		drivetrain.changeToLoGear();
		drivetrain.drive(robotSpeed, -robotSpeed); // sets drivetrain to speed
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double error = drivetrain.getLeftSpeed() - drivetrain.getRightSpeed(); // subtracts to find error value
		if (Math.abs(error) > 0.001) { // checks to see if the error value is greater than .001
			// drives only left side
			adjustedSpeed -= 0.0001 * error; // changes adjustedSpeed to adjustedSpeed + a constant*error
			// System.out.println("LeftDistance: " +
			// drivetrain.getLeftDistance());
			// System.out.println("RightDistance: " +
			// drivetrain.getRightDistance());
			// System.out.println("RightSpeed: " + drivetrain.getRightSpeed());
			// System.out.println("LeftSpeed: " + drivetrain.getLeftSpeed());
			double speedChange = .5 + (distance - drivetrain.getRightDistance()) / distance;
			if (drivetrain.getLeftDistance() >= (distance * .7)) {
				double leftSpd = robotSpeed * speedChange;
				double rightSpd = adjustedSpeed * speedChange;
				double minSpeed = .1;
				if (Math.abs(leftSpd) <= minSpeed && leftSpd > 0) {
					leftSpd = minSpeed;
				} else if (Math.abs(leftSpd) <= minSpeed && leftSpd < 0) {
					leftSpd = -minSpeed;
				} 

				if (Math.abs(rightSpd) <= minSpeed && rightSpd > 0) {
					rightSpd = minSpeed;
				} else if (Math.abs(rightSpd) <= minSpeed && rightSpd < 0) {
					rightSpd = -minSpeed;
				} 
				drivetrain.drive(leftSpd, rightSpd);
				System.out.println("Distance: " + drivetrain.getLeftDistance());
			} else {
				drivetrain.leftDrive(robotSpeed);
				drivetrain.rightDrive(adjustedSpeed);// sets right side to
														// adjustedSpeed
				System.out.println("should be numbers: " + robotSpeed + " " + adjustedSpeed);
			}
			// we did all of this to make the robot drive straight, as
			// naturally, it doesn't
		} 

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		 System.out.println("leftdistance: " + drivetrain.getLeftDistance() +
		 " distance: " + distance);
		if (Math.abs(drivetrain.getLeftDistance()) >= Math.abs(distance)) {
			return true;
		} else {

			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.drive(0, 0);
		System.out.println("yeeeeee boiiiiiii");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("maybe im interrupted");
	}
}