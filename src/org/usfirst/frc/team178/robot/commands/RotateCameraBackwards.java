package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateCameraBackwards extends Command {
	DriveTrain drivetrain;

	public RotateCameraBackwards() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		drivetrain = Robot.drivetrain;
		System.out.println("Start");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
			drivetrain.moveServo(0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (drivetrain.getServo() <= 0.1) {
			return true;
		} else {
			return false;
		}

	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println("End");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drivetrain.moveServo(0);
	}
}
