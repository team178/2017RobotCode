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

	public GearGobbler() {
		extendRetract = new DoubleSolenoid(RobotMap.GEARGOBBLER1, RobotMap.GEARGOBBLER1);
		ultrasonic = new AnalogInput(1);
	}
	public void moveGobbler() {
		if(extendRetract.get() == DoubleSolenoid.Value.kForward){
			extendRetract.set(DoubleSolenoid.Value.kReverse);
		}
		else if(extendRetract.get() == DoubleSolenoid.Value.kReverse){
			
			//if (getValue() > 0 && getValue() < 5)  {
			extendRetract.set(DoubleSolenoid.Value.kForward);
			//}
		}
	}
	
	public DoubleSolenoid.Value getGobbler() {
		return extendRetract.get();
	}
	
	public int getValue() {
		return ultrasonic.getValue(); //Check method?
	}
	
    public void initDefaultCommand() {
       //empty 
    }
}

