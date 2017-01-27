package org.usfirst.frc.team178.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick Pooja = new Joystick(RobotMap.JoystickPort); //I am sorry. jk best decision. 
	Button button1 = new JoystickButton(Pooja, 1);
	Button button2 = new JoystickButton(Pooja, 2);
	Button button3 = new JoystickButton(Pooja, 3);
	Button button4 = new JoystickButton(Pooja, 4);
	Button button5 = new JoystickButton(Pooja, 5);
	Button button6 = new JoystickButton(Pooja, 6);
	Button button7 = new JoystickButton(Pooja, 7);
	
	Joystick Elizabeth = new Joystick(RobotMap.JoystickPortXbox);
	Button buttonA = new JoystickButton(Elizabeth, 1);
	Button buttonX = new JoystickButton(Elizabeth, 3);
	Button buttonY = new JoystickButton(Elizabeth, 4);
	Button lBumper = new JoystickButton(Elizabeth, 6);
	Button rBumper = new JoystickButton(Elizabeth, 5);
	Button buttonB = new JoystickButton(Elizabeth, 2);
	Button backButton = new JoystickButton(Elizabeth, 7);
	Button startButton = new JoystickButton(Elizabeth, 8); 
 
	
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
