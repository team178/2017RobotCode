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
		gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		currentAngle = gyro.getAngle();
		double speedChange = ((targetAngle - currentAngle) / targetAngle);
		
		if (Math.abs(currentAngle) >= (Math.abs(targetAngle)/2)) {
			 drivetrain.drive(lSpeed * speedChange, rSpeed * speedChange);
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
		drivetrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("?????");
	}
}