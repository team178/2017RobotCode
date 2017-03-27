package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetDefaultLights extends Command {
//	LightsSubsystem lights;
    public SetDefaultLights() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   // 	requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//lights = Robot.lights;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	lights.setBaseColor(SubsystemIndex.ALL);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
