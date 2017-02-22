package org.usfirst.frc.team178.robot.subsystems;

import com.ctre.CANTalon;
import org.usfirst.frc.team178.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelShooter extends Subsystem {
	
	public static CANTalon shooter1;
	public static CANTalon shooter2;
	public static Encoder encoder;
	public static Servo servo;
	
	public FuelShooter() {
	
	shooter1 = new CANTalon(RobotMap.Shooter1);
	shooter2 = new CANTalon(RobotMap.Shooter2);
	encoder = new Encoder(RobotMap.SHOOTERencoderA, RobotMap.SHOOTERencoderB, true, Encoder.EncodingType.k4X);
	servo = new Servo(RobotMap.SERVO);
	
	double dpp = (60.0/1024.0);
	encoder.setDistancePerPulse(dpp);
	}
	
	//used to shoot and to turn off shooter
	public void shoot(double shootSpeed) {
		shooter1.set(shootSpeed);
		shooter2.set(-shootSpeed);
	}
	
	public void stop() {
		shoot(0);
	}
	public double getEncoderValue() {
		return encoder.getRate();
	}
	
	public void moveServo(double value){
		servo.set(value);
	}
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

