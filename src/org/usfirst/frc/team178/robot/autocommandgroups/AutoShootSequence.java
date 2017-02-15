package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootSequence extends CommandGroup {
	

    public AutoShootSequence() {
    	addSequential(new DriveDistance(0.5,56));
    	addSequential(new AutoTurn(0.5,0), 1);
    	addSequential(new DriveDistance(0.5,26));
    	addSequential(new AutoTurn(0.5,0), 1);
    	addSequential(new CenterOnAirship()); //Replace after LineUpToShoot is written
    	addSequential(new ShootFuel());
       //General sequence based off of positioning
       //Drive forward, turn, aim
    }
}
