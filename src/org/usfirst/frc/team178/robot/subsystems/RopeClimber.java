package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeClimber extends Subsystem {
	
	public static CANTalon climber1;
	public static CANTalon climber2;
	
	public RopeClimber() {
		climber1 = new CANTalon(RobotMap.Climber1);
		climber2 = new CANTalon(RobotMap.Climber2);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void climb(double climbspeed1, double climbspeed2) {
    	climber1.set(climbspeed1);
    	climber2.set(climbspeed2);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

