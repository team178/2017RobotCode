package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftSpeed extends Command {
	DriveTrain speedShifter;
	OI oi;

    public ShiftSpeed() {
    	requires(Robot.drivetrain);
    	speedShifter = Robot.drivetrain;
    	oi = Robot.oi;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	speedShifter.changeToLoGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(!oi.button1.get())
    	{
    		return true;
    	}
    	else 
    	{
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	speedShifter.changeToHiGear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

    }
}
