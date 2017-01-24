package org.usfirst.frc.team178.robot.subsystems;

public class DriveTrain extends Subsystem {
	 
	CANtalon left1;
	CANtalon left2;
	CANtalon right1;
	CANtalon right2;

	public DriveTrain (int c1, int c2, int c3, int c4) {
		left1= new CANtalon(c1);
		left2= new CANtalon(c2);
		right1= new CANtalon(c3);
		right2= new CANtalon(c4);
		
	}
	}
