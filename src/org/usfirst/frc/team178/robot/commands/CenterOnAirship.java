package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.VisionStreamer;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class CenterOnAirship extends Command {


	private final Object imgLock = new Object();
	DriveTrain drivetrain;
    public CenterOnAirship() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public void centerAndAdvance() {
		double centerX;
		synchronized (imgLock) {
			centerX = frontCamera.getTapeCenterX();
		}
		double turn = centerX - (frontCamera.getIMG_WIDTH() / 2);
		drive.arcadeDrive(-0.6, turn * 0.005);
	}
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
