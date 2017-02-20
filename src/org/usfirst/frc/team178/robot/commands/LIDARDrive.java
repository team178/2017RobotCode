package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.LIDAR;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LIDARDrive extends Command {

		DriveTrain drivetrain;
		LIDAR lidar;
		double distance;
		double robotSpeed;
		

    public LIDARDrive(double dist, double speed) {
    	//dist should be in inches
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain);
    	requires (Robot.lidar);
    	distance = dist;
    	robotSpeed = speed;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lidar.start();
    	drivetrain= Robot.drivetrain;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(robotSpeed, -robotSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(1 == (distance - lidar.getDistance()*0.39)){
    		return true;
    	} else {
    		return false;
    	}
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
