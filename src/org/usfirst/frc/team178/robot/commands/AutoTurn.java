package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.*;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;

/** 
 * 
 */
public class AutoTurn extends Command {
	OI oi;
	DriveTrain drivetrain;
	AnalogGyro gyro;
	double lSpeed, rSpeed, targetAngle, currentAngle;
	LightsSubsystem lights;

	public AutoTurn(double tAngle, double speed) {
		requires(Robot.drivetrain);
		requires(Robot.lights);
		targetAngle = tAngle;
		lSpeed = speed;
		rSpeed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		oi = Robot.oi;
		drivetrain = Robot.drivetrain;
		gyro = Robot.gyro;
		lights = Robot.lights;
		System.out.println("i ahve startesdf");
		drivetrain.changeToLoGear();
		gyro.reset();
		lights.sendMessage(SubsystemIndex.ALL, "orange");

		
		
	}

	// Consistently changes Angle until it is at a "targetAngle"
	protected void execute() {
		currentAngle = gyro.getAngle();
			double speedChange = ((targetAngle - currentAngle) / targetAngle);
		
		if (Math.abs(currentAngle) >= (0.7*(Math.abs(targetAngle)))) {
			double leftSpd = lSpeed * speedChange;
			double rightSpd = rSpeed * speedChange;
			double minSpeed = .1;
			if (Math.abs(leftSpd) <= minSpeed && leftSpd > 0) {
				leftSpd = minSpeed;
			} else if (Math.abs(leftSpd) <= minSpeed && leftSpd < 0) {
				leftSpd = -minSpeed;
			} 

			if (Math.abs(rightSpd) <= minSpeed && rightSpd > 0) {
				rightSpd = minSpeed;
			} else if (Math.abs(rightSpd) <= minSpeed && rightSpd < 0) {
				rightSpd = -minSpeed;
			} 
		} else {
			drivetrain.drive(lSpeed, rSpeed);
		}

	}

	//When the currentAngle is the same or equal to the targetAngle, this is finished.
	protected boolean isFinished() {
		if (Math.abs(currentAngle) >= Math.abs(targetAngle)) {
			System.out.println("done " + currentAngle + "      " + targetAngle);
			return true;
		} else {
			return false;
		}
	}

	// The robot won't spin aimlessly after this is finished.
	protected void end() {
		System.out.println("End turn");
		drivetrain.drive(0, 0);
		lights.setBaseColor(SubsystemIndex.ALL);
	}

	// Idek what this is
	protected void interrupted() {
		System.out.println("?????");
		lights.setBaseColor(SubsystemIndex.ALL);
	}
}