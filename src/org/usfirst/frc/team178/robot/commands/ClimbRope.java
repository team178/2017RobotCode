package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.RopeClimber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbRope extends Command {
	RopeClimber ropeclimber;
	OI oi;

	public ClimbRope() {
		requires(Robot.ropeclimber);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		ropeclimber = Robot.ropeclimber;
		oi = Robot.oi;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		ropeclimber.climb(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		if (oi.lBumper.get() == false) {
			return true;
		} else {
			{
				return false;
			}
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		ropeclimber.climb(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
