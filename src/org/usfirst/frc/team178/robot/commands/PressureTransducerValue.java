package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.Pneumatics;
/**
 *
 */
public class PressureTransducerValue extends Command {
	
	Pneumatics pneumatics;
	AnalogInput pressureTransducer;

    public PressureTransducerValue() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	pneumatics = Robot.pneumatics;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pneumatics.getPressure();
    	System.out.println("pneumatics.getPressure");
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
