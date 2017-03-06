package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearLeftDelay extends CommandGroup {

    public AutoGearLeftDelay() {
    	addSequential(new PauseRobot(2));
    	addSequential(new DriveDistance(-0.01, -0.1), 1);
    	addSequential(new DriveDistance(80, 0.8));
		addSequential(new AutoTurn(50, 0.3));
		//addSequential(Timer.delay(4));
		//addSequential(new CenterOnAirship(), 3);
		addSequential(new DriveDistance(75, 0.6));
    }
}
