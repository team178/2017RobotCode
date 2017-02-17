package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;


import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DoNothing extends Command {
	LightsSubsystem lights;
	double time;
	
    public DoNothing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lights = Robot.lights;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	time = timeSinceInitialized();
    	System.out.println(time);
    	if (time <= 1){
    		lights.sendMessage(0, "Ocean");
    	}
    	else if (time <= 2){
    		lights.sendMessage(1, "red");
    	}
    	else if (time <= 3){
    		lights.sendMessage(2, "Rainbow");
    	}
    	System.out.println("Execute");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (time >= 4){
    		return true;
    	}
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
