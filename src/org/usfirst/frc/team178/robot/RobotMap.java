package org.usfirst.frc.team178.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
/*
  *2017 I/O List
  *https://docs.google.com/spreadsheets/d/1UKpSRuZrjuywv0qT_H1iGqm0bs0VatQ2Ny5uf1lUkLQ/edit#gid=0
*/
public class RobotMap {

	public static int JoystickPort = 0; //computer
	public static int JoystickPortXbox = 1; //computer
	
	//DM = DriveMotor
	public static int DMTOPright = 1; //CAN
	public static int DMMIDDLEright = 2; //CAN
	public static int DMBOTTOMright = 3; //CAN
	public static int DMTOPleft = 4; //CAN
	public static int DMMIDDLEleft = 5; //CAN
	public static int DMBOTTOMleft = 6; //CAN
	
	public static int PCM = 7; //CAN
	
	public static int PDP = 0; //CAN
	
	public static int BallSweep1 = 8; //CAN
	public static int BallSweep2 = 9; //CAN
	
	public static int Climber1 = 10; //CAN
	public static int Climber2 = 11; //CAN
	
	public static int Shooter1 = 12; //CAN
	public static int Shooter2 = 13; //CAN
	public static int Shooter3 = 14; //CAN
	
	public static int DRIVEencoderRA = 0;  //DIO
	public static int DRIVEencoderRB = 1;  //DIO
	public static int DRIVEencoderLA = 2;  //DIO
	public static int DRIVEencoderLB = 3;  //DIO
	public static int SHOOTERencoderA = 4; //DIO
	public static int SHOOTERencoderB = 5; //DIO
	
	public static int PRESSURETRANSDUCER = 0; //Analog
	public static int GYRO = 1; //Analog
	public static int ULTRASONICGG = 2; //Analog
	public static int ULTRASONICDT = 3; //Analog
	
	public static int CAMERA1 = 1; //USB
	public static int CAMERA2 = 2; //USB

	public static int SHIFTHI = 0; // PCM Channel
	public static int SHIFTLOW = 1; // PCM Channel
	
	public static int GEARGOBBLER1 = 2; //PCM Channel
	public static int GEARGOBBLER2 = 3; //PCM Channel
	
	public static int SERVO_shooter = 0; //PWM 
	public static int SERVO_drivetrain = 1; //PWM
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
