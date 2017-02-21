	package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGobbler extends Subsystem {

    public static DoubleSolenoid extendRetract;
    public static AnalogInput ultrasonic;
    public static DigitalInput limitSwitch;

	public GearGobbler() {
		extendRetract = new DoubleSolenoid(RobotMap.PCM, RobotMap.GEARGOBBLER2, RobotMap.GEARGOBBLER1);
		limitSwitch = new DigitalInput(RobotMap.GGLimitSwitch);
		//ultrasonic = new AnalogInput(RobotMap.ULTRASONIC);
	}
	public void moveGobbler() {
		if(extendRetract.get() == DoubleSolenoid.Value.kForward){
			extendRetract.set(DoubleSolenoid.Value.kReverse);
			System.out.println("in");
		}
		else {			
			extendRetract.set(DoubleSolenoid.Value.kForward);

			System.out.println("out");
		}
	}
	public void retractGobbler() {
		extendRetract.set(DoubleSolenoid.Value.kReverse);
	}
	public void extendGobbler() {
		extendRetract.set(DoubleSolenoid.Value.kForward);
	}
	
	public DoubleSolenoid.Value getGobbler() {
		return extendRetract.get();
	}
	
	public int getValue() {
		return ultrasonic.getValue(); //Check method?
	}
	
	public boolean getToggled(){
		return limitSwitch.get();
	}
	
    public void initDefaultCommand() {
       //empty 
    }
}

