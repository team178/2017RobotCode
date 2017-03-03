package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearSequenceLeft extends CommandGroup {

    public AutoGearSequenceLeft() {
    	addSequential(new DriveDistance(-0.01, -0.1), 1);
    	addSequential(new DriveDistance(65, 0.8));
		addSequential(new AutoTurn(30, 0.3));
		//addSequential(Timer.delay(4));
		addSequential(new CenterOnAirship(), 2);
		addSequential(new DriveDistance(50, 0.6));
        //General sequence for autonomous gears, may need variations
    	//Center: Drive forward, center, place gear
    	//Left or right: Drive forward, rotate, center, place gear 
    }
}

