package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.LIDAR;
import org.usfirst.frc.team178.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LIDARDistance extends Command {
	LIDAR lidar;
	
	
    public LIDARDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lidar = Robot.lidar;
    	lidar.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lidar.pidGet();
    	System.out.println(lidar.getDistance());
    	//System.out.println("distance: " + lidar.pidGet());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	lidar.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
