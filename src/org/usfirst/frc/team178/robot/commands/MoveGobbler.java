package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.RobotMap.SubsystemIndex;
import org.usfirst.frc.team178.robot.subsystems.GearGobbler;
import org.usfirst.frc.team178.robot.subsystems.LightsSubsystem;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
// This is where the code calls the GearGobbler and the DoubleSolenoid.
public class MoveGobbler extends Command {
	GearGobbler geargobbler;
	LightsSubsystem lights;
	DoubleSolenoid.Value initial;

	// This is where it requires code from the GearGobbler.
	public MoveGobbler() {
		requires(Robot.geargobbler);
    	requires(Robot.lights);
	}

	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);

	// This is where the code for the GearGobbler is started when it is called
	// upon.
	protected void initialize() {
		geargobbler = Robot.geargobbler;
		initial = geargobbler.getGobbler();
		lights = Robot.lights;
    	lights.sendMessage(SubsystemIndex.BALLTRACK, "seaweed");
		System.out.println(initial);
	}

	// This is where the code for the GearGobbler is executed.
	// If the value is the same as the DoubleSolenoid, then it retracts.
	// If the value is not equal to the DoubleSolenois, then it extends.
	protected void execute() {
		geargobbler.extendGobbler();
	}

	// Make this return true when this Command no longer needs to run execute()
	// This is when the the value for the GearGobbler equals the value of the
	// DoubleSolenoid.
	// This is where the code is finished.
	protected boolean isFinished() {
		return false;

	}

	// Called once after isFinished returns true
	protected void end() {
		geargobbler.retractGobbler();
		lights.setBaseColor(SubsystemIndex.BALLTRACK);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		geargobbler.retractGobbler();
		lights.setBaseColor(SubsystemIndex.BALLTRACK);
	}
}
