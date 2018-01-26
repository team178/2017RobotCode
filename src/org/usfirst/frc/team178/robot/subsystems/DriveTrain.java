package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// This is where the the motors, encoders, and the DoubleSolenoid that are
// needed for the DriveTrain.
public class DriveTrain extends Subsystem {

	public static Talon left1;
	public static Talon left2;
	public static Talon left3;
	public static Talon right1;
	public static Talon right2;
	public static Talon right3;
	public static Encoder right;
	public static Encoder left;
	public static DoubleSolenoid speedShifter;
	public static AnalogInput ultrasonic;
	public static Servo servo;

	// This is where the motors in the DriveTrain are given a direction to move
	// in.
	public DriveTrain() {

		left1 = new Talon(RobotMap.DMTOPleft);
		left2 = new Talon(RobotMap.DMMIDDLEleft);
		left3 = new Talon(RobotMap.DMBOTTOMleft);
		right1 = new Talon(RobotMap.DMTOPright);
		right2 = new Talon(RobotMap.DMMIDDLEright);
		right3 = new Talon(RobotMap.DMBOTTOMright);
		right = new Encoder(RobotMap.DRIVEencoderRA, RobotMap.DRIVEencoderRB, false, Encoder.EncodingType.k4X);
		left = new Encoder(RobotMap.DRIVEencoderLA, RobotMap.DRIVEencoderLB, true, Encoder.EncodingType.k4X);
		speedShifter = new DoubleSolenoid(RobotMap.PCM, RobotMap.SHIFTLOW, RobotMap.SHIFTHI);
		ultrasonic = new AnalogInput(RobotMap.ULTRASONICDT);
		servo = new Servo(RobotMap.SERVO_drivetrain);

		// TODO: set left and right encoder distance per pulse here! :)

		speedShifter.set(DoubleSolenoid.Value.kReverse);
		double dpp = 3 * ((6 * Math.PI) / 1024); // distance per pulse
													// (circumference/counts per
													// revolution)
		right.setDistancePerPulse(dpp); // must be changed for both right and
										// left
		left.setDistancePerPulse(dpp);

	}

	// This is where the Encoders on the DriveTrain are reset.
	public void resetEncoders() {
		right.reset();
		left.reset();
	}

	// This is where the DoubleSolenoid value is set to forward, which causes it
	// to move in low gear.
	public void changeToLoGear() {
		speedShifter.set(DoubleSolenoid.Value.kForward); // forward is low gear,
															// port 1
		System.out.println("switch");
	}

	// This is where the DoubleSolenoid value is set to reverse, which causes it
	// to move in high gear.
	public void changeToHiGear() {
		speedShifter.set(DoubleSolenoid.Value.kReverse); // forward is hi gear,
															// port 0
	}

	// These are the three motors for the leftDrive that are set to certain
	// speeds.
	public void leftDrive(double speed) {
		left1.set(speed);
		left2.set(speed);
		left3.set(speed);
	}

	// These are the three motors for the rightDrive that are set to certain
	// speeds.
	public void rightDrive(double speed) {
		right1.set(speed);
		right2.set(speed);
		right3.set(speed);
	}

	// This is where the code tells the three motors from each side to drive at
	// a certain speed.
	public void drive(double leftMotors, double rightMotors) {
		left1.set(leftMotors);
		left2.set(leftMotors);
		left3.set(leftMotors);
		right1.set(rightMotors);
		right2.set(rightMotors);
		right3.set(rightMotors);
	}

	//
	public void correctSpeed(double left, double right) {

		if (Math.abs(left) <= .2) {
			left = .2;
		}
		if (Math.abs(right) <= .2) {
			right = .2;
		}
		if (left >= -.2 && left <= 0) {
			left = -.2;
		}
		if (right >= -.2 && right <= 0) {
			right = -.2;
		}
		drive(left,right);

	}

	// This is where the DriveTrain gets the distances traveled and the speeds
	// at which they h traveled.
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

	public double getDistanceDT() {
		return ultrasonic.getVoltage();
	}

	public void moveServo(double value) {
		servo.set(value);
	}

	// This tells the Servo the position it is supposed to be in and is
	// currently in.
	public double getServo() {
		return servo.getPosition();
	}

	// Used when DriveTrain ends whatever previous command
	// Basically when DriveTrain is idling
	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}
}
