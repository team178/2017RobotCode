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
	int dRotation;
	double dRate, speed;

    public DriveDistance(int rotation, double rate, double speed) {
    	requires (Robot.drivetrain);
    	dRotation = rotation;
    	dRate = rate;
    	speed = this.speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi= Robot.oi;
    	drivetrain= Robot.drivetrain;
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.drive(speed, -speed);
    	System.out.println("weeeeeeee");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(drivetrain.right.get() == dRotation){
        	return true;
        }
        else
        {
        	return false;
        }
        //frick man idk
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.drive(0, 0);
    }
}
