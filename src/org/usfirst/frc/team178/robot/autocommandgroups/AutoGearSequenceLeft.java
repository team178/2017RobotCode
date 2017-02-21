package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequenceLeft extends CommandGroup {
	DriverStation ds = DriverStation.getInstance();

    public AutoGearSequenceLeft() {
    		addSequential(new DriveDistance(197.75, 0.3));
    		addSequential(new AutoTurn(90, 0.3));
    		addSequential(new CenterOnAirship());
    		addSequential(new DriveDistance(103.845, 0.5));
    		addSequential(new MoveGobbler());
        //General sequence for autonomous gears, may need variations
    	//Center: Drive forward, center, place gear
    	//Left or right: Drive forward, rotate, center, place gear 
    }
}

