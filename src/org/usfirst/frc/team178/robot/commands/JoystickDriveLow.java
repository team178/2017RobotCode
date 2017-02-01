package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDriveLow extends Command {
	DriveTrain drivetrain;
	OI oi;
	double yVal,twistVal;

    public JoystickDriveLow() {
    	requires(Robot.drivetrain);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    	System.out.println("JoystickDriveLow Start");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.changeToLoGear();
    	yVal = oi.getY();
		twistVal = oi.getTwist();
		//System.out.println("Y Val: " + yVal);
		//System.out.println("Twist Val: " + twistVal);
		//System.out.println("X Val: " + oi.getX());

		
		//The if condition implements what's called a dead zone. 
		//Makes it so that the robot will only drive when the driver is touching the joystick. Joysticks sometimes send
		//small numbers when they're not actually touched, so this eliminates that. 

		if(Math.abs(yVal)>0.1 || Math.abs(twistVal)>0.1){
			drivetrain.drive(twistVal-yVal, twistVal+yVal);
		}
		else {
			drivetrain.drive(0,0);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {	
    	return !oi.button1.get();
    	//returns true if trigger is not held
    }
    

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.changeToHiGear();
    	System.out.println("JoystickDriveLow End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}