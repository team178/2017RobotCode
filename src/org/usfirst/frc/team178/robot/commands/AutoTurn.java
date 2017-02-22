package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;

/** 
 * 
 */
public class AutoTurn extends Command {
	OI oi;
	DriveTrain drivetrain;
	AnalogGyro gyro;
	double lSpeed, rSpeed, targetAngle, currentAngle;

	public AutoTurn(double tAngle, double speed) {
		requires(Robot.drivetrain);
		targetAngle = tAngle;
		lSpeed = speed;
		rSpeed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = Robot.oi;
		drivetrain = Robot.drivetrain;
		gyro = Robot.gyro;
		System.out.println("i ahve startesdf");
		drivetrain.changeToLoGear();
		gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		currentAngle = gyro.getAngle();
		double speedChange = ((targetAngle - currentAngle) / targetAngle);
		
		if (Math.abs(currentAngle) >= (0.7*(Math.abs(targetAngle)))) {
			double leftSpd = lSpeed * speedChange;
			double rightSpd = rSpeed * speedChange;
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
		} else {
			drivetrain.drive(lSpeed, rSpeed);
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(currentAngle) >= Math.abs(targetAngle)) {
			System.out.println("done " + currentAngle);
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("End turn");
		drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("?????");
	}
}