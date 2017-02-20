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
		double adjustedSpeed;
		

    public LIDARDrive(double dist, double speed) {
    	//dist should be in inches
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain);
    	//requires (Robot.lidar);
    	distance = dist;
    	robotSpeed = speed;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain= Robot.drivetrain;
    	lidar.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(robotSpeed, -robotSpeed);
    	double error = drivetrain.getLeftSpeed() - drivetrain.getRightSpeed(); //subtracts to find error value
    	if (Math.abs(error) > 0.001)	{ //checks to see if the error value is greater than .001
    		 //drives only left side
    	    adjustedSpeed = 0.0001*error; //changes adjustedSpeed to adjustedSpeed + a constant*error
        	double speedChange = (distance-drivetrain.getRightDistance())/distance;
        	if (lidar.getDistance() >= (distance*.5))
        	{
        		drivetrain.drive(robotSpeed*speedChange, adjustedSpeed*speedChange);
        	}
        	else
        	{
        		drivetrain.leftDrive(robotSpeed);
        		drivetrain.rightDrive(adjustedSpeed);//sets right side to adjustedSpeed

        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(1 >= (distance - lidar.getDistance()*0.39)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0,0);
    	lidar.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.drive(0, 0);
    	lidar.stop();
    }
}
