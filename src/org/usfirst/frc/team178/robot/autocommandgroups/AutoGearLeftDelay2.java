package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearLeftDelay2 extends CommandGroup {

    public AutoGearLeftDelay2() {
    	addSequential(new DriveDistance(-6, -0.1), 1);
		addSequential(new AutoTurn(RobotMap.AutoGearTurn, 0.4), 1);
		addSequential(new DriveDistance(-25, -0.5));
		System.out.println("I AM DRIVING ON THE LEFT SIDE");
		// addSequential(Timer.delay(4));
    }
}
