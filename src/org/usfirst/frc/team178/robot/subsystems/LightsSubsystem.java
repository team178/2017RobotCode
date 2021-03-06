package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
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
	private DriverStation ds;
	
	public LightsSubsystem() {
		arduino = new I2C(I2C.Port.kOnboard, 8);
		ds = DriverStation.getInstance();
		setBaseColor(SubsystemIndex.ALL);
	}

   public void setBaseColor(SubsystemIndex subsystem) {
	   if (ds.getAlliance() == Alliance.Blue) {
		   sendMessage(subsystem, "Ocean");
	   }
	   else if (ds.getAlliance() == Alliance.Red){
		   sendMessage(subsystem, "Fire");
	   }
   }
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void sendMessage(SubsystemIndex subsystem, String pattern) {
    	String message = subsystem.ordinal() + pattern;
    	message = message.toLowerCase();
    	System.out.println(message);
    	arduino.writeBulk(message.getBytes());
    }
}
