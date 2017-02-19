package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequence extends CommandGroup {

    public AutoGearSequence() {
    	DriverStation ds = DriverStation.getInstance();
    	
    	//Left alignment
    	if(ds.getLocation() == 1) { //It's either 1 or 3
    		addSequential(new DriveDistance(691.25, 0.5));
    		addSequential(new AutoTurn(90, 0.5));
    		addSequential(new DriveDistance(103.845, 0.5));
    		addSequential(new CenterOnAirship());
    		addSequential(new MoveGobbler());
    	}
    	//Center alignment
    	else if(ds.getLocation() == 2){
    		addSequential(new DriveDistance(0.5, 83)); //Change speed after testing
    		addSequential(new CenterOnAirship()); 
    		addSequential(new MoveGobbler());
    	} 
    	//Right alignment
    	else {
    		addSequential(new DriveDistance(691.25, 0.5));
    		addSequential(new AutoTurn(90, -0.5));
    		addSequential(new DriveDistance(103.845, 0.5));
    		addSequential(new CenterOnAirship());
    		addSequential(new MoveGobbler());
    	}
        //General sequence for autonomous gears, may need variations
    	//Center: Drive forward, center, place gear
    	//Left or right: Drive forward, rotate, center, place gear 
    }
}

