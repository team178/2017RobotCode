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

    public ShootFuel() {
    	requires (Robot.fuelshooter);
    	requires(Robot.lights);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    public ShootFuel(double timeParameter) {
    	time = timeParameter;
    	requires(Robot.fuelshooter);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	fuelshooter = Robot.fuelshooter;
    	lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.SHOOTER, "enforcers shot");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fuelshooter.shoot(1);
    	Timer.delay(3);
    	fuelshooter.moveServo(0.5);
    }
    // Make this return true when this Command no longer needs to run execute()
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
    protected void end() {
    	System.out.println("end");
    	fuelshooter.stop();
    	lights.setBaseColor(SubsystemIndex.SHOOTER);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fuelshooter.stop();
    }
    

}
