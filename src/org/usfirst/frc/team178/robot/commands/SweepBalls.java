package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.OI;
import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.BallSweeper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SweepBalls extends Command {
	BallSweeper ballsweeper;
	
	//This is where SweepBalls requires the ballsweeper
    public SweepBalls() {
       requires(Robot.ballsweeper);
    }

    // Called just before this Command runs the first time
    //ballsweeper is ready to start
    protected void initialize() {
    	ballsweeper = Robot.ballsweeper;
    	System.out.println("BallSweeeper Start");
    }

    // Called repeatedly when this Command is scheduled to run
    //ballsweeper is at speed of 1
    protected void execute() {
    	ballsweeper.setSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    //ballsweeper runs throughout of teleoperated period
    protected boolean isFinished() {
        return false;
    	
    }

    // Called once after isFinished returns true
    //speed goes down to zero at the end of the match
    protected void end() {
    	ballsweeper.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	ballsweeper.setSpeed(0);
    }
}
