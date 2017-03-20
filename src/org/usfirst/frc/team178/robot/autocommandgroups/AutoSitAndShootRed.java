package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.ShootFuel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSitAndShootRed extends CommandGroup {

    public AutoSitAndShootRed() {
    	addSequential(new ShootFuel(8));
    	addSequential(new AutoTurn(-80, -0.4));
    	addSequential(new DriveDistance(115, 0.5));
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
