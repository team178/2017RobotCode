package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.MoveGobbler;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequenceMiddle extends CommandGroup {

    public AutoGearSequenceMiddle() {
    	addSequential(new DriveDistance(-0.01, -0.1), 1);
    	addSequential(new DriveDistance(46.63, 0.4)); //Change speed after testing
    	//addSequential(new CenterOnAirship(), 3);
		addSequential(new DriveDistance(46.63, 0.2));
    }
}
