package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.VisionStreamer;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnBoiler extends Command {

	private final Object imgLock = new Object();
	DriveTrain drivetrain;
	VisionStreamer camera;
	double drive;
	int thresholdX;
	int thresholdY;
	
    public CenterOnBoiler() {
    	requires(Robot.drivetrain);
		drivetrain = Robot.drivetrain;
		thresholdX = 70;
		thresholdY = 332;
		camera = Robot.shooterCamera;
		requires(Robot.shooterCamera);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive = -.1;
		drivetrain.changeToLoGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Start");
    	double yError = camera.getCenterYfromCameraCenterY()+262;
    	double xError = camera.getCenterXfromCameraCenterX();
    	//Adjust horizontal
    	if ((Math.abs(xError) > thresholdX) && (Math.abs(xError) < 350)) {
			drive = -.0015 * xError;
			drivetrain.drive(drive/2, drive/2);
			//System.out.println("CenterX: " + centerX);
			drivetrain.correctSpeed();
		}else if(Math.abs(xError) > 300){
			System.out.println("WHAT THE ACTUAL HECK IS THIS?????");
		}else{
			drivetrain.drive(0, 0);
		}
    	//Adjust vertical
		if ((Math.abs(yError) > thresholdY) && (Math.abs(yError) < 350)) {
			drive = -.0015 * yError;
			drivetrain.drive(drive/2, -drive/2);
			drivetrain.correctSpeed();
			System.out.println(camera.getCenterYfromCameraCenterY());
		}else if(Math.abs(yError) > 300){
			System.out.println("still not really sure what this does, but hey, if it works");
		}else{
			drivetrain.drive(0, 0);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(camera.getCenterYfromCameraCenterY()) < thresholdY &&
    			Math.abs(camera.getCenterXfromCameraCenterX()) < thresholdX)  {
    		System.out.println("THRESHOLD END: " + ((camera.getBlendedCenterY()) - (camera.getIMG_HEIGHT() / 2)));
    		drivetrain.drive(0, 0);
    		return true;
	} else {
		return false;
		}
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Finished");
    	drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.drive(0, 0);
    }
}
