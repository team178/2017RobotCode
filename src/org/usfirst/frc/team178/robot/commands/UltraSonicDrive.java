package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltraSonicDrive extends Command {
	OI oi;
	DriveTrain drivetrain;
	double distance;
	double adjustedSpeed;

	public UltraSonicDrive(double dist) {
		requires(Robot.drivetrain);
		distance = dist;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = Robot.oi;
		drivetrain = Robot.drivetrain;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivetrain.drive(0.3, -0.3);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (drivetrain.getDistanceDT() <= distance) {
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
		drivetrain.drive(0, 0);
	}
}
