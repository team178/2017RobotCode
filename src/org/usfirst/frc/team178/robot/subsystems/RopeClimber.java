package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
//This is where the motors needed for the RopeClimber are defined.
public class RopeClimber extends Subsystem {
	
	public static TalonSRX climber1;
	public static TalonSRX climber2;
	
	//This is where the motors are given the name "climber" from the RobotMap.
	public RopeClimber() {
		climber1 = new TalonSRX(RobotMap.Climber1);
		climber2 = new TalonSRX(RobotMap.Climber2);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//This is where the Climbers are given a particular climbSpeed that is used when the robot is using the RopeClimber.
    public void climb(double climbspeed) {
    	//climber1.set(climbspeed);
    	//climber2.set(climbspeed);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

