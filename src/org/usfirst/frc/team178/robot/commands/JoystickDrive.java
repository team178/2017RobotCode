package org.usfirst.frc.team178.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team178.robot.*;
import org.usfirst.frc.team178.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class JoystickDrive extends Command {
	
	OI oi;
	DriveTrain drivetrain;
	double yVal,twistVal;
	//This shows where the code for JoystickDrive is coming from.
	public JoystickDrive()
	{
		requires(Robot.drivetrain);
	}
	//This is where the code gets the oi and drivetrain and starts the code.
    protected void initialize() {
    	oi = Robot.oi;
    	drivetrain = Robot.drivetrain;
    }
	//This is where the direction of the Joystick os determined depending upon the value received from the DoubleSolenoid. 
	protected void execute() {
		//Joystick returns from -1 to 1, motor takes values from -1 to 1.
		if (oi.button1.get() && DriveTrain.speedShifter.get() == DoubleSolenoid.Value.kReverse)
		{
			drivetrain.changeToLoGear();
		}
		else if (!oi.button1.get() && DriveTrain.speedShifter.get() == DoubleSolenoid.Value.kForward)
		{
			drivetrain.changeToHiGear();
		}
		if (oi.rBumper.get()) {
			yVal = oi.getXBoxY();
			System.out.println("hiiiiii cap");
			twistVal = oi.getXBoxX();
		}
		else {
			yVal = oi.getY();
			twistVal = 0.5*(oi.getTwist());
		}
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

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	//	drivetrain.drive(0,0);
	}

	protected void interrupted() {

	}
}
