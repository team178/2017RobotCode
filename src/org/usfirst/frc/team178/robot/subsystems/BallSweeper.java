package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallSweeper extends Subsystem {

    public static CANTalon left;
    public static CANTalon right; 

	public BallSweeper() {
		left = new CANTalon(RobotMap.BallSweep1);
		right = new CANTalon(RobotMap.BallSweep2);
	}
	
	public void ballSweep(double leftSpeed, double rightSpeed) {
  		left.set(leftSpeed);
  		right.set(rightSpeed);
}

    public void initDefaultCommand() {
       //empty 
    }
}



