package org.usfirst.frc.team178.robot.commands; 
 
import org.usfirst.frc.team178.robot.OI; 
import org.usfirst.frc.team178.robot.Robot; 
import org.usfirst.frc.team178.robot.subsystems.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command; 
 
/** 
 * 
 */ 
public class AutoTurn extends Command { 
  OI oi; 
  DriveTrain drivetrain;
  AnalogGyro gyro;
  double lSpeed, rSpeed, targetAngle, currentAngle; 
 
    public AutoTurn(double tAngle, double speed) { 
        requires(Robot.drivetrain); 
        targetAngle = tAngle;
        lSpeed = speed;
        rSpeed = speed;
    } 
 
    // Called just before this Command runs the first time 
    protected void initialize() { 
      oi = Robot.oi; 
      drivetrain = Robot.drivetrain; 
      gyro = Robot.gyro;
      currentAngle = gyro.getAngle();
    } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute() {
      gyro.reset();
      while(currentAngle < targetAngle){
    	  drivetrain.drive(lSpeed, rSpeed);
    	  System.out.println(currentAngle);
      }
     
    } 
 
    // Make this return true when this Command no longer needs to run execute() 
    protected boolean isFinished() { 
        return currentAngle >= targetAngle; 
    } 
 
    // Called once after isFinished returns true 
    protected void end() { 
    	drivetrain.drive(0, 0);
    } 
 
    // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() { 
    } 
} 