package org.usfirst.frc.team178.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.*;

/**
 *
 */
public class DriveDistance extends Command {
	OI oi;
	DriveTrain drivetrain;
	double distance;
	double adjustedSpeed;

    public DriveDistance(/*double dist*/) {
    	requires (Robot.drivetrain);
    	//distance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi= Robot.oi;
    	drivetrain= Robot.drivetrain;
    	adjustedSpeed = -0.1;
    	drivetrain.drive(0.1,-0.1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error = drivetrain.getLeftSpeed() - drivetrain.getRightSpeed(); //subtracts to find error value
    	if (Math.abs(error) > 0.001){
    		drivetrain.leftDrive(0.1);
    		adjustedSpeed += 0.0001*error;
        	drivetrain.rightDrive(adjustedSpeed); 
        	System.out.println(error);
        	
    	}
    	
    	
    	//System.out.println("Left: " + drivetrain.getELeft());
    	//System.out.println("Right: " + drivetrain.getERight());
    	//System.out.println("isStraight: " + drivetrain.isStraight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime == 2) {
    		return true;
    	}
    	else {
        	return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    
    }
}
