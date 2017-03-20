package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.RobotMap;
import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.CenterOnBoiler;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.PauseRobot;
import org.usfirst.frc.team178.robot.commands.ShootFuel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDoubleSequenceRight extends CommandGroup {

    public AutoDoubleSequenceRight() {
    	//AutoGearSequenceRight
    	addSequential(new DriveDistance(-6, -0.1), 1);
    	addSequential(new DriveDistance(RobotMap.AutoGearDistA, 1));
		addSequential(new AutoTurn(-RobotMap.AutoGearTurn, -0.4));
		addSequential(new DriveDistance(-20, -0.5));
		addSequential(new CenterOnAirship(), 4);
		addSequential(new PauseRobot(2));
        //AutoShootSequence +180 turn
		addSequential(new DriveDistance(-45, -0.3)); //Reverse in case of barriers
		addSequential(new AutoTurn(180, 0.3)); //Or some value close to 180
		addSequential(new DriveDistance(53, 0.8));
		//addSequential(new CenterOnBoiler());
		addSequential(new ShootFuel(5)); //Or at least until end of auto
		//There are two barriers, which are on the sides of the middle peg
		//They're 2ft long and 6in tall
		//There should be enough room for an approximate 180 after backing up
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
