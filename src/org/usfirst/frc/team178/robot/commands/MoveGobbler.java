package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.GearGobbler;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveGobbler extends Command {
	GearGobbler geargobbler;
	
	
	
	
	
	
	public MoveGobbler()
	{
		requires(Robot.GearGobbler);
		geargobbler = Robot.geargobbler;
	}
		
		
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	doublesolenoid = Robot.doubleSolenoid;
    	analoginput = Robot.analogInput;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		geargobbler.moveGobbler();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
