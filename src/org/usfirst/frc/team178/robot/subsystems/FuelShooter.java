package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.subsystems.CANTalon;
import org.usfirst.frc.team178.robot.subsystems.Encoder;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelShooter extends Subsystem {
	public static CANTalon shooter1;
	public static CANTalon shooter2;
	public static CANTalon shooter3;
	public static Encoder eshooter;
	
	
	public FuelShooter() {
	
	shooter1 = new CANTalon(RobotMap.Shooter1);
	shooter2 = new CANTalon(RobotMap.Shooter2);
	shooter3 = new CANTalon(RobotMap.Shooter3);
	eshooter = new Encoder(RobotMap.ENCODERshooter1, RobotMap.ENCODERshooter2);
	
	}
	public void shoot(double speed1, double speed2, double speed3) {
		shooter1.set(speed1);
		shooter2.set(speed2);
		shooter3.set(speed3);
		
		
	}
	
	public double getEncoderValue() {
		return eshooter.getRate();
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

