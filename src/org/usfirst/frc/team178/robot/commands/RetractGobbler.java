package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.GearGobbler;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//this is where the retractGobbler command calls for the pneumatics and the geargobbler
public class RetractGobbler extends Command {
		GearGobbler geargobbler;
		DoubleSolenoid.Value initial;
    public RetractGobbler() {
    	requires(Robot.geargobbler);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    //This is where the RetractGobbler command begins as it calls commands from the geargobbler
    protected void initialize() {
    	geargobbler = Robot.geargobbler;
    }

    // Called repeatedly when this Command is scheduled to run
    //This is when the geargobbler retracts.
    protected void execute() {
    	geargobbler.retractGobbler();
    }

    // Make this return true when this Command no longer needs to run execute()
    //This checks if the geargobbler is in the right position based off of the pneumatics
    protected boolean isFinished() {
    	if (geargobbler.getGobbler() == DoubleSolenoid.Value.kReverse)
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
