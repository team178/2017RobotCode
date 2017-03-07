package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.DriveTrain;
import org.usfirst.frc.team178.robot.subsystems.LIDAR;
import org.usfirst.frc.team178.robot.subsystems.VisionStreamer;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterOnAirship extends Command {

	private final Object imgLock = new Object();
	DriveTrain drivetrain;
	VisionStreamer camera;
	LIDAR lidar;
	double turn;
	int threshold;

	public CenterOnAirship() {
		requires(Robot.drivetrain);
		requires(Robot.lidar);
		lidar = Robot.lidar;
		drivetrain = Robot.drivetrain;
		requires(Robot.gearCamera);
		camera = Robot.gearCamera;
		threshold = 30;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turn = -.1;
		drivetrain.changeToLoGear();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double x = lidar.getDistance();
		double adjustedCenter = 0.0284*(Math.pow(x, 2)) - 7.75*x + 994.5;
		System.out.println(adjustedCenter);
		System.out.println("BLENDED CENTER: " + camera.getBlendedCenterX());
		double error = adjustedCenter - (camera.getBlendedCenterX());
		//System.out.println("error: " + error);
		if ((Math.abs(error) > threshold) && (Math.abs(error) < 400)) {
			turn = -.0015 * error;
			drivetrain.drive(turn/2, turn/2);
			
		}else if(Math.abs(error) > 400){
			
		}else{
			drivetrain.drive(0, 0);
		}
		//print statements for testing & scaling
		if (((timeSinceInitialized()*1000)%250) <= 20) {
			//System.out.println("BlendedCenter: " + camera.getBlendedCenterX());
			//System.out.println("Distance: " + lidar.getDistance());
			//System.out.println("Error: " + error);
			//System.out.println("Turn: " + turn);
		}
	}

/*
		int errorFlexibility = 50;
		if (error > errorFlexibility) {
		//if true, the camera center is to right of the tape, needs to turn left
			turn += .00001 * error;
			drivetrain.drive(turn, 0.1);
			error = camera.getCenterXfromCameraCenterX();//(camera.getBlendedCenterX()) - (camera.getIMG_WIDTH() / 2);
		}else if (error < (-1*errorFlexibility)) {
		//if true, the camera center is to left of the tape, needs to turn right
			turn += .00001 * error;
			drivetrain.drive(0.1, turn);
			error = camera.getCenterXfromCameraCenterX();//(camera.getBlendedCenterX()) - (camera.getIMG_WIDTH() / 2);
		}else{
		drivetrain.drive(0, 0);
		}
 */

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(camera.getCenterXfromCameraCenterX()) < threshold || Math.abs(camera.getCenterXfromCameraCenterX()) > 400) {
			//System.out.println("THRESHOLD END: " + ((camera.getBlendedCenterX()) - (camera.getIMG_WIDTH() / 2)));
			drivetrain.drive(0, 0);
			return false;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		drivetrain.drive(0, 0);
		drivetrain.changeToHiGear();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drivetrain.drive(0, 0);
	}
}