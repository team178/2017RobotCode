package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	public static Compressor airCompressor;
	public static AnalogInput pressureTransducer;
	
	public Pneumatics() { 
		
		pressureTransducer	 = new AnalogInput(RobotMap.PRESSURETRANSDUCER);
		airCompressor = new Compressor();
		airCompressor.start();
			
	}
	
	public double getPressure() {
		return pressureTransducer.getVoltage();
	}
	
	
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

