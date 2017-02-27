package org.usfirst.frc.team178.robot.commands;

import org.usfirst.frc.team178.robot.Robot;
import org.usfirst.frc.team178.robot.subsystems.GearGobbler;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//This is where the code calls the GearGobbler and the DoubleSolenoid. 
public class MoveGobbler extends Command {
	GearGobbler geargobbler;
	DoubleSolenoid.Value initial;
	//This is where it requires code from the GearGobbler.
	public MoveGobbler() {
		requires(Robot.geargobbler);
	}

	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);

	// This is where the code for the GearGobbler is started when it is called upon.
	protected void initialize() {
		geargobbler = Robot.geargobbler;
		initial = geargobbler.getGobbler();
		System.out.println(initial);
	}

	// This is where the code for the GearGobbler is executed. 
	//If the value is the same as the DoubleSolenoid, then it retracts.
	//If the value is not equal to the DoubleSolenois, then it extends.
	protected void execute() {
		if (initial == DoubleSolenoid.Value.kForward) {
			geargobbler.retractGobbler();
		} else {
			geargobbler.extendGobbler();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	//This is when the the value for the GearGobbler equals the value of the DoubleSolenoid.
	//This is where the code is finished.
	protected boolean isFinished() {
		DoubleSolenoid.Value current = geargobbler.getGobbler();
		if (initial != current) {
			System.out.println("finished: " + initial + "->" + current);
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
