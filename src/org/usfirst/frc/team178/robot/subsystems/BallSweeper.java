package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallSweeper extends Subsystem {

    public static Talon left;
    public static Talon right; 

    //These are the motors necessary for the sweeper
	public BallSweeper() {
		left = new Talon(RobotMap.BallSweep1);
		right = new Talon(RobotMap.BallSweep2);
	}
	
	//Sets the two speeds of the sweeper
	public void setSpeed(double speed) {
  		left.set(-speed);
  		right.set(speed);
}

    public void initDefaultCommand() {
       //empty 
    }
}



