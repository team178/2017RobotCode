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

    		addSequential(new DriveDistance(41.5, 0.3));
    		addSequential(new AutoTurn(-90, -0.3));
    		addSequential(new DriveDistance(69.25, 0.5));
    		addSequential(new CenterOnBoiler()); 
    		addSequential(new ShootFuel());    	  
       //General sequence based off of positioning
       //Drive forward, turn, aim
    }
}
