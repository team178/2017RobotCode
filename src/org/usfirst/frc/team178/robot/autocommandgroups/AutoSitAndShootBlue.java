package org.usfirst.frc.team178.robot.autocommandgroups;

import org.usfirst.frc.team178.robot.commands.AutoTurn;
import org.usfirst.frc.team178.robot.commands.DriveDistance;
import org.usfirst.frc.team178.robot.commands.ShootFuel;
import org.usfirst.frc.team178.robot.commands.UltraSonicDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSitAndShootBlue extends CommandGroup {

    public AutoSitAndShootBlue() {
    	addSequential(new DriveDistance(-6, -0.1), 1);
    	addSequential(new DriveDistance(35, 0.4));
    	addSequential(new AutoTurn(-115, -0.4));
    	addSequential(new UltraSonicDrive(0.4));
    	addSequential(new ShootFuel(5));
    	addSequential(new DriveDistance(-30, -0.4), 4);
    	addSequential(new AutoTurn(115, 0.4));
    	addSequential(new DriveDistance(50, 0.7));
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
