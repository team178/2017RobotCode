package org.usfirst.frc.team178.robot.subsystems;

import com.ctre.CANTalon;
import org.usfirst.frc.team178.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
//This is where the motors are stated for use in the FuelShooter subsystem.
public class FuelShooter extends Subsystem {
	
	public static CANTalon shooter1;
	public static CANTalon shooter2;
	public static Encoder encoder;
	public static Servo servo;
	
	//This is where the motors are defined.
	public FuelShooter() {
	
	shooter1 = new CANTalon(RobotMap.Shooter1);
	shooter2 = new CANTalon(RobotMap.Shooter2);
	encoder = new Encoder(RobotMap.SHOOTERencoderA, RobotMap.SHOOTERencoderB, true, Encoder.EncodingType.k4X);
	servo = new Servo(RobotMap.SERVO);
	
	//This is where the distance per pulse is found for the encoder.
	double dpp = (60.0/1024.0);
	encoder.setDistancePerPulse(dpp);
	}
	
	//used to shoot and to turn off shooter
	//This is where the shoot speed is set for the two shooters on the FuelShooter.
	public void shoot(double shootSpeed) {
		shooter1.set(shootSpeed);
		shooter2.set(-shootSpeed);
	}
	
	//This is where the shoot speed is 0 and the FuelShooter stops.
	public void stop() {
		shoot(0);
	}
	
	//This is where the encoder is returned to find the rate.
	public double getEncoderValue() {
		return encoder.getRate();
	}
	
	//This is where the Servo is told to move and given a value.
	public void moveServo(double value){
		servo.set(value);
	}
	
	//This tells the Servo the position it is supposed to be in and is currently in.
	public double getServo(){
		return servo.getPosition();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

