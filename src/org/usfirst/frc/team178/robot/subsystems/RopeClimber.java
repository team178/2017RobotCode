package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.CANTalon;

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

    public void climb(double climbspeed) {
    	climber1.set(climbspeed);
    	climber2.set(climbspeed);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

