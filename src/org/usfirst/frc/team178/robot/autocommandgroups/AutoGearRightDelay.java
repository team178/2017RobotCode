package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.PauseRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearRightDelay extends CommandGroup {

    public AutoGearRightDelay() {
    	addSequential(new PauseRobot(2));
    	addSequential(new DriveDistance(-0.01, -0.1), 1);
    	addSequential(new DriveDistance(RobotMap.AutoGearDistA, 0.8));
		addSequential(new AutoTurn(-RobotMap.AutoGearTurn, -0.3));
		//addSequential(Timer.delay(4));
		addSequential(new CenterOnAirship(), 3);
		addSequential(new DriveDistance(RobotMap.AutoGearDistB, 0.6));
    }
}
