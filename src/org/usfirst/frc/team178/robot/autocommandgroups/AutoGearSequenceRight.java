package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.MoveGobbler;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequenceRight extends CommandGroup {

    public AutoGearSequenceRight() {
    	addSequential(new DriveDistance(131.83, 0.3));
		addSequential(new AutoTurn(-30, -0.3));
		addSequential(new CenterOnAirship());
		addSequential(new DriveDistance(103.845, 0.5));
		addSequential(new MoveGobbler());
    }
}
