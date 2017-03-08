package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLightRobot extends Command {
	LightsSubsystem lights;
	double time;
	
	// Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    public AutoLightRobot() {
    	requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lights = Robot.lights;
    }

    // If time is between 0 and 1, do Enforcers lights.
    //If time is between 1 and 2, do Fire lights.
    //If time is between 2 and 3, do enforcers lights.
    //If time is between 3 and 4, do Fire lights.
    protected void execute() {
    	time = timeSinceInitialized();
    	System.out.println(time);
    	if (time <= 1){
    	//	lights.sendMessage(SubsystemIndex.ALL, "Enforcers");
    		lights.setBaseColor(SubsystemIndex.ALL);
    	}
    	else if (time <= 2){
    		lights.sendMessage(SubsystemIndex.SHOOTER, "Fire");
    	}
    	else if (time <= 3){
    		lights.sendMessage(SubsystemIndex. GOBBLER, "Enforcers");
    	}
    	else if (time <= 4){
    		lights.sendMessage(SubsystemIndex.CLIMBER, "Fire");
    	}
    	System.out.println("Execute");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (time >= 5){
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
