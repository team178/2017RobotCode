package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.FuelShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootFuel extends Command {
	FuelShooter fuelshooter;
	OI oi;
	public boolean checkshooter = false;

    public ShootFuel() {
    	requires (Robot.fuelshooter);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fuelshooter = Robot.fuelshooter;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fuelshooter.shoot(1,1);
    
    	if (checkshooter == false) {
    		fuelshooter.shoot(1, 1);
    		checkshooter = true;
    	} else if (checkshooter == true) {
    		fuelshooter.stop();
    		checkshooter = false;
    	}
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return true;
       
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    

}
