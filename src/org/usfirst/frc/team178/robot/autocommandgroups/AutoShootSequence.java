package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootSequence extends CommandGroup {
	

    public AutoShootSequence() {
    	DriverStation ds = DriverStation.getInstance();
    	if(ds.getLocation() == 1) {
    		addSequential(new DriveDistance(41.5, 0.5));
    		addSequential(new AutoTurn(90, 0.5));
    		addSequential(new DriveDistance(207.75, 0.5));
    		addSequential(new CenterOnAirship()); //Replace w/ LineUpToShoot
    		addSequential(new ShootFuel());    		
    	}
    	else if(ds.getLocation() == 2) {
    		addSequential(new DriveDistance(41.5, 0.5));
    		addSequential(new AutoTurn(90, 0.5));
    		addSequential(new DriveDistance(138.5, 0.5));
    		addSequential(new CenterOnAirship()); //Replace w/ LineUpToShoot
    		addSequential(new ShootFuel());    	
    	}
    	else {
    		addSequential(new DriveDistance(41.5, 0.5));
    		addSequential(new AutoTurn(90, 0.5));
    		addSequential(new DriveDistance(69.25, 0.5));
    		addSequential(new CenterOnAirship()); //Replace w/ LineUpToShoot
    		addSequential(new ShootFuel());    	
    	}
       //General sequence based off of positioning
       //Drive forward, turn, aim
    }
}
