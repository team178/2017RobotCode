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
    	addSequential(new DriveDistance(83, 0.3)); //Change speed after testing
		addSequential(new CenterOnAirship()); 
		addSequential(new MoveGobbler());
    }
}
