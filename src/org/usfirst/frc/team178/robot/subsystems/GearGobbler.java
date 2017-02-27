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

	//gets robot map and shows where the gobbler is on the robot. Also identifies the gobbler's switch
    public GearGobbler() {
		extendRetract = new DoubleSolenoid(RobotMap.PCM, RobotMap.GEARGOBBLER2, RobotMap.GEARGOBBLER1);
		limitSwitch = new DigitalInput(RobotMap.GGLimitSwitch);
		//ultrasonic = new AnalogInput(RobotMap.ULTRASONIC);
	}
    
   //gets the doublesolenoid value, and if it is a certain value, then the system prints "in". If not, prints "out."
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
	
	//retracts gobbler by using reverse
	public void retractGobbler() {
		extendRetract.set(DoubleSolenoid.Value.kReverse);
	}
	
	//extends gobbler by using forward
	public void extendGobbler() {
		extendRetract.set(DoubleSolenoid.Value.kForward);
	}
	
	//determines if the gobbler is extended or retracted
	public DoubleSolenoid.Value getGobbler() {
		return extendRetract.get();
	}
	
	//gets value of ultrasonic
	public int getValue() {
		return ultrasonic.getValue(); 
	}
	
	public boolean getToggled(){
		return limitSwitch.get();
	}
	
    public void initDefaultCommand() {
       //empty 
    }
}

