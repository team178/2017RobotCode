package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequenceLeft extends CommandGroup {

	public AutoGearSequenceLeft() {
		addSequential(new DriveDistance(-6, -0.1), 1);
		addSequential(new DriveDistance(RobotMap.AutoGearDistA, 1));
		addSequential(new AutoTurn(RobotMap.AutoGearTurn, 0.3));
		System.out.println("I AM DRIVING ON THE LEFT SIDE");
		// addSequential(Timer.delay(4));
		addSequential(new CenterOnAirship(), 4);
		// General sequence for autonomous gears, may need variations
		// Center: Drive forward, center, place gear
		// Left or right: Drive forward, rotate, center, place gear
	}
}