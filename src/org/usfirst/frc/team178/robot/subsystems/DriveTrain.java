package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.JoystickDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public static CANTalon left1;
	public static CANTalon left2;
	public static CANTalon left3;
	public static CANTalon right1;
	public static CANTalon right2;
	public static CANTalon right3;
	public static Encoder right;
	public static Encoder left;
	public static DoubleSolenoid speedShifter;

	public DriveTrain() {

		left1 = new CANTalon(RobotMap.DMTOPleft);
		left2 = new CANTalon(RobotMap.DMMIDDLEleft);
		left3 = new CANTalon(RobotMap.DMBOTTOMleft);
		right1 = new CANTalon(RobotMap.DMTOPright);
		right2 = new CANTalon(RobotMap.DMMIDDLEright);
		right3 = new CANTalon(RobotMap.DMBOTTOMright);
		right = new Encoder(RobotMap.DRIVEencoderRA, RobotMap.DRIVEencoderRB, false, Encoder.EncodingType.k4X);
		left = new Encoder(RobotMap.DRIVEencoderLA, RobotMap.DRIVEencoderLB, true, Encoder.EncodingType.k4X);
		speedShifter = new DoubleSolenoid(RobotMap.PCM, RobotMap.SHIFTLOW, RobotMap.SHIFTHI);
		
		
		// TODO: set left and right encoder distance per pulse here! :)
		
		speedShifter.set(DoubleSolenoid.Value.kForward);
		double dpp = 3*((6*Math.PI)/1024); //distance per pulse (circumference/counts per revolution)
		right.setDistancePerPulse(dpp); //must be changed for both right and left
		left.setDistancePerPulse(dpp);
		
	}
	
	public void resetEncoders()	{
		right.reset();
		left.reset();
	}
	
	public void changeToLoGear() {
		speedShifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void changeToHiGear() {
		speedShifter.set(DoubleSolenoid.Value.kForward);
	}

	public void leftDrive(double speed) {
		left1.set(speed);
		left2.set(speed);
		left3.set(speed);
	}
	
	public void rightDrive(double speed) {
		right1.set(speed);
		right2.set(speed);
		right3.set(speed);
	}
	
	public void drive(double leftMotors, double rightMotors) {
		left1.set(leftMotors);
		left2.set(leftMotors);
		left3.set(leftMotors);
		right1.set(rightMotors);
		right2.set(rightMotors);
		right3.set(rightMotors);
	}

	public double getLeftDistance() {
		return left.getDistance();
	}

	public double getRightDistance() {
		return right.getDistance();
	}

	public double getRightSpeed() {
		return right.getRate();
	}
	
	public double getLeftSpeed() {
		return left.getRate();
	}
	
	public boolean isStraight() {
		if (Math.abs(getLeftDistance() - getRightDistance()) < 0.1) {
			return true;
		} else {
			return false;
		}
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
