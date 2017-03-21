package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.FuelShooter;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootFuel extends Command {
	LightsSubsystem lights;
	FuelShooter fuelshooter;
	OI oi;
	double time;

	//The ShootFuel command requires the fuelshooter here
    public ShootFuel() {
    	time = 100000000;
    	requires (Robot.fuelshooter);
    	requires(Robot.lights);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    //this is where a time parameter is created so that the fuelshooter shoots in increments
    public ShootFuel(double timeParameter) {
    	time = timeParameter;
    	requires(Robot.fuelshooter);
    }
    // Called just before this Command runs the first time
    //fuelshooter is initialized and is ready to go!
    protected void initialize() {
    	fuelshooter = Robot.fuelshooter;
    	lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.BALLTRACK, "enforcers shot");
    }

    // Called repeatedly when this Command is scheduled to run
    //Shoots at a speed of 1
    protected void execute() {
    	fuelshooter.shoot(0.95);
    	System.out.println(fuelshooter.getEncoderValue());
    	if (fuelshooter.getEncoderValue() >= 3000) { //rpm
    		fuelshooter.moveServo(0.5); 
    	}
        

    }
    // Make this return true when this Command no longer needs to run execute()
    //If the time parameter is equal to the passed time, then the command is stopped.
    protected boolean isFinished() {
    	double passedTime = timeSinceInitialized();
    	if (passedTime >= time) {
    		return true;
    	}
    	else {
    		return false;
    	}
       
    }

    // Called once after isFinished returns true
    //Stops the fuelshooter once and for all
    protected void end() {
    	System.out.println("end");
    	fuelshooter.stop();
    	lights.setBaseColor(SubsystemIndex.BALLTRACK);
    	fuelshooter.moveServo(0); 
    	System.out.println("end: " +fuelshooter.getServo());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fuelshooter.stop();
    	fuelshooter.moveServo(0);
    	lights.setBaseColor(SubsystemIndex.BALLTRACK);
    	System.out.println("end: " +fuelshooter.getServo());
    }
    

}
