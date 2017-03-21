package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team178.robot.commands.CenterOnAirship;
import org.usfirst.frc.team178.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick Pooja = new Joystick(RobotMap.JoystickPort); //I am sorry. jk best decision. 
	public Button button1 = new JoystickButton(Pooja, 1);
	public Button button2 = new JoystickButton(Pooja, 2);
	public Button button3 = new JoystickButton(Pooja, 3);
	public Button button4 = new JoystickButton(Pooja, 4);
	public Button button5 = new JoystickButton(Pooja, 5);
	public Button button6 = new JoystickButton(Pooja, 6);
	public Button button7 = new JoystickButton(Pooja, 7);
	
	static Joystick Elizabeth = new Joystick(RobotMap.JoystickPortXbox);
	public Button buttonA = new JoystickButton(Elizabeth, 1);//used for GearGobbler command
	public Button buttonX = new JoystickButton(Elizabeth, 3);
	public Button buttonY = new JoystickButton(Elizabeth, 4);
	public Button lBumper = new JoystickButton(Elizabeth, 5);
	public Button rBumper = new JoystickButton(Elizabeth, 6);
	public Button buttonB = new JoystickButton(Elizabeth, 2);
	public Button backButton = new JoystickButton(Elizabeth, 7);
	public Button startButton = new JoystickButton(Elizabeth, 8); 
 
	
	public OI() {
		buttonB.whileHeld(new MoveGobbler());
		button3.whenPressed(new LIDARDrive(10, 0.1));
		buttonA.whileHeld(new ShootFuel());
		rBumper.whileHeld(new SweepBalls());
		lBumper.whileHeld(new ClimbRope());
		//buttonX.whenPressed(new CenterOnBoiler());
		startButton.whenPressed(new RotateCameraForward());
		backButton.whenPressed(new RotateCameraBackwards());
		//buttonX.whenPressed(new CenterOnAirship());
		//buttonY.whenPressed(new DriveDistance(45, 0.3));
		//button4.whenPressed(new ExtendGobbler());
		//button5.whenPressed(new RetractGobbler());
		//buttonX.whenPressed(new AutoTurn(360, 0.1));
		buttonX.whileHeld(new CenterOnAirship());
		
	}
	 public double getX (){
	    	return Pooja.getX();
	    }
	    
	    public double getY (){
	    	return Pooja.getY();
	    }
	    
	    public double getTwist (){
	    	return Pooja.getRawAxis(3); //3 is axis for rotate 
	    }
	public double getXBoxY() {
		return Elizabeth.getRawAxis(5); //5 is axis for movement value
		//Up is negative, down is positive
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
