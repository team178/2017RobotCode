package org.usfirst.frc.team178.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

//idk cuz programming didn't work on this
public class LightsSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private I2C arduino;
	
	public LightsSubsystem() {
		arduino = new I2C(I2C.Port.kOnboard, 8);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void sendMessage(int subsystem, String pattern) {
    	String message = subsystem + pattern;
    	message = message.toLowerCase();
    	System.out.println(message);
    	arduino.writeBulk(message.getBytes());
    }
}
