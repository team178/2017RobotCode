package org.usfirst.frc.team178.robot.commands; 
 
import org.usfirst.frc.team178.robot.OI; 
import org.usfirst.frc.team178.robot.Robot; 
import org.usfirst.frc.team178.robot.subsystems.*; 
 
import edu.wpi.first.wpilibj.command.Command; 
 
/** 
 * 
 */ 
public class AutoTurn extends Command { 
  OI oi; 
  DriveTrain drivetrain; 
  double lSpeed, rSpeed; 
 
    public AutoTurn(double left, double right) { 
        requires(Robot.drivetrain); 
        lSpeed = left; 
        rSpeed = right; 
    } 
 
    // Called just before this Command runs the first time 
    protected void initialize() { 
      oi = Robot.oi; 
      drivetrain = Robot.drivetrain; 
    } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute() { 
      drivetrain.drive(lSpeed, rSpeed); 
    } 
 
    // Make this return true when this Command no longer needs to run execute() 
    protected boolean isFinished() { 
        return isTimedOut(); 
    } 
 
    // Called once after isFinished returns true 
    protected void end() { 
    } 
 
    // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() { 
    } 
} 