package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallSweeper extends Subsystem {

    public static TalonSRX left;
    public static TalonSRX right; 

    //These are the motors necessary for the sweeper
	public BallSweeper() {
		left = new TalonSRX(RobotMap.BallSweep1);
		right = new TalonSRX(RobotMap.BallSweep2);
	}
	
	//Sets the two speeds of the sweeper
	public void setSpeed(double speed) {
  		//left.set(null, -speed);
  		//right.set(speed);
}

    public void initDefaultCommand() {
       //empty 
    }
}



