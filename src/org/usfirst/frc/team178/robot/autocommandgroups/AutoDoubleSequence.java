package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDoubleSequence extends CommandGroup {

    public AutoDoubleSequence() {
    	//AutoGearSequenceLeft
    	addSequential(new DriveDistance(-0.01, -0.1), 1);
    	addSequential(new DriveDistance(RobotMap.AutoGearDistA, 0.8));
		addSequential(new AutoTurn(RobotMap.AutoGearTurn, 0.3));
		addSequential(new CenterOnAirship(), 3);
		addSequential(new DriveDistance(RobotMap.AutoGearDistB, 0.6));
        //AutoShootSequence +180 turn
		addSequential(new DriveDistance(-45, -0.3)); //Reverse in case of barriers
		addSequential(new AutoTurn(180, 0.3)); //Or some value close to 180
		addSequential(new DriveDistance(53, 0.8));
		addSequential(new CenterOnBoiler());
		addSequential(new ShootFuel(5)); //Or at least until end of auto
		//There are two barriers, which are on the sides of the middle peg
		//They're 2ft long and 6in tall
		//There should be enough room for an approximate 180 after backing up
    }
}
