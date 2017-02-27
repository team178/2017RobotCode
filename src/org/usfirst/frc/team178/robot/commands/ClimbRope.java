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

	// Calls for the rope climber and oi
	protected void initialize() {
		ropeclimber = Robot.ropeclimber;
		oi = Robot.oi;
	}

	//Simply has the rope climb at a speed of 1
	protected void execute() {
		ropeclimber.climb(1);
	}

	// This is in the endgame, so there is no need for this stuff
	protected boolean isFinished() {
		return false;
	}

	//Rope speed is 0
	protected void end() {
		ropeclimber.climb(0);
	}

	//Abandons this if something goes wrong since it is in the endgame
	protected void interrupted() {
		ropeclimber.climb(0);
	}
}
