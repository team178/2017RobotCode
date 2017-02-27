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

    // This calls the geargobbler and starts the code for the first time.
    protected void initialize() {
    	geargobbler = Robot.geargobbler;
    }

    // This consistently runs the command when it is called upon.
    protected void execute() {
    	geargobbler.extendGobbler();
    }

    //This basically ends the code if it can sense that the gear is in the gobbler and the code returns true. 
    protected boolean isFinished() {
    	if (geargobbler.getGobbler() == DoubleSolenoid.Value.kForward)
    	{
    		return true;
    	}
    	else {
        return false;
    	}
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
