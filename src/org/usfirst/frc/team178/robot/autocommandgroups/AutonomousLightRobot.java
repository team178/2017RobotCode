package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoLightRobot;
import org.usfirst.frc.team178.robot.commands.DriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousLightRobot extends CommandGroup {

    public AutonomousLightRobot() {
    	addSequential(new AutoLightRobot());
        //addSequential(new DriveDistance(0, 0, 0));
        //Once lights are done, add commands for lights
        //DriveDistance may not be needed
    }
}
