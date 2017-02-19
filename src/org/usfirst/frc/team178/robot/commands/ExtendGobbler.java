package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.GearGobbler;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendGobbler extends Command {
		GearGobbler geargobbler;
		DoubleSolenoid.Value initial;
    public ExtendGobbler() {
    	requires(Robot.geargobbler);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	geargobbler = Robot.geargobbler;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	geargobbler.extendGobbler();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (geargobbler.getGobbler() == DoubleSolenoid.Value.kForward)
    	{
    		return true;
    	}
    	else {
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
