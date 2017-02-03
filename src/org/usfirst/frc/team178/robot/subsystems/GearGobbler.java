package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGobbler extends Subsystem {

    public static DoubleSolenoid extendRetract;
    public static AnalogInput ultrasonic;    

	public GearGobbler() {
		extendRetract = new DoubleSolenoid(2, 3);
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
	
	public int getValue() {
		return ultrasonic.getValue(); //Check method?
	}
	
    public void initDefaultCommand() {
       //empty 
    }
}

