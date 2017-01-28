package org.usfirst.frc.team178.robot.subsystems;

import com.ctre.CANTalon;
import org.usfirst.frc.team178.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelShooter extends Subsystem {
	
	public static CANTalon shooter1;
	public static CANTalon shooter2;
	public static CANTalon shooter3;
	public static Encoder encoder;
	
	public FuelShooter() {
	
	shooter1 = new CANTalon(RobotMap.Shooter1);
	shooter2 = new CANTalon(RobotMap.Shooter2);
	shooter3 = new CANTalon(RobotMap.Shooter3);
	encoder = new Encoder(RobotMap.SHOOTERencoderA, RobotMap.SHOOTERencoderB);
	
	}
	
	//used to shoot and to turn off shooter
	public void shoot(double shootSpeed, double intakeSpeed) {
		shooter1.set(shootSpeed);
		shooter2.set(shootSpeed);
		shooter3.set(intakeSpeed);
	}
	
	public void stop() {
		shoot(0,0);
	}
	public double getEncoderValue() {
		return encoder.getRate();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

