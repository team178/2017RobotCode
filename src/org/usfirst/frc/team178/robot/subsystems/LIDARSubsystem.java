package org.usfirst.frc.team178.robot.subsystems;

import org.usfirst.frc.team178.robot.LIDAR;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LIDARSubsystem extends Subsystem {

    LIDAR lidar;
    
	public LIDARSubsystem() {
		lidar = new LIDAR(Port.kOnboard); 
	}

    public void initDefaultCommand() {
        //empty for now, maybe change later
    }
}

