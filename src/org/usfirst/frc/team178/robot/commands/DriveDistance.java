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

    public DriveDistance(/*double dist*/) {
    	requires (Robot.drivetrain);
    	//distance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi= Robot.oi;
    	drivetrain= Robot.drivetrain;
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(0.1, 0.1);
    /*	double error = drivetrain.getLeftDistance() - drivetrain.getRightDistance(); //subtracts to find error value
    	drivetrain.leftDrive(0.1); 
    	drivetrain.rightDrive(0.1 + 0.1*error); */
    	
    	//System.out.println("Left: " + drivetrain.getELeft());
    	//System.out.println("Right: " + drivetrain.getERight());
    	//System.out.println("isStraight: " + drivetrain.isStraight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	/*if (drivetrain.getLeftDistance() >= distance  && drivetrain.getRightDistance >= distance) {
    		return true;
    	}
    	else {*/
        	return false;
    	
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
