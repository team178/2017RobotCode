package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequence extends CommandGroup {

    public AutoGearSequence() {
    	DriverStation ds = DriverStation.getInstance();
    	
    	if(ds.getLocation() == 1) { //It's either 1 or 3
    		addSequential(new DriveDistance(0.5, 112)); //Change speed after testing
    		addSequential(new CenterOnAirship()); 
    		addSequential(new MoveGobbler());
    	}
    	//Left alignment
    	else if(ds.getLocation() == 2){
    		addSequential(new AutoTurn(0, 0.5)); //Adjust values after testing
    		addSequential(new DriveDistance(0.5, 231)); 
    		addSequential(new AutoTurn(0.5, 0));
    		addSequential(new DriveDistance(0.5, 111));
    		addSequential(new CenterOnAirship());
    		addSequential(new MoveGobbler());
    	} 
    	//Right alignment
    		addSequential(new AutoTurn(0.5, 0));
    		addSequential(new DriveDistance(0.5, 231));
    		addSequential(new AutoTurn(0, 0.5));
    		addSequential(new DriveDistance(0.5, 111));
    		addSequential(new CenterOnAirship());
    		addSequential(new MoveGobbler());
    	}
        //General sequence for autonomous gears, may need variations
    	//Center: Drive forward, center, place gear
    	//Left or right: Drive forward, rotate, center, place gear 
    }
}
