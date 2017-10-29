package org.usfirst.frc.team4239.robot;


import org.usfirst.frc.team4239.robot.commands.ReverseArcadeDrive;
import org.usfirst.frc.team4239.robot.commands.ToggleShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick controller;//xbox controller
	public Joystick joystick;
	public JoystickButton button1,
						button2,
						button4,
						button3,
						jbutton1,
						jbutton3,
						jbutton4,
						jbutton5,
						jbutton6;
	
	public OI(){
		controller = new Joystick(0);
		joystick = new Joystick(1);
		
		
		button1 = new JoystickButton(controller, 1);
		button2 = new JoystickButton(controller, 2);
		button3 = new JoystickButton(controller, 3);
		button4 = new JoystickButton(controller, 4);
		
		jbutton1 = new JoystickButton(joystick, 1);
		jbutton3 = new JoystickButton(joystick, 3);
		jbutton4 = new JoystickButton(joystick, 4);
		jbutton5 = new JoystickButton(joystick, 5);
		jbutton6 = new JoystickButton(joystick, 6);
		
		button1.whileHeld(new ReverseArcadeDrive());
		jbutton1.whenPressed(new ToggleShooter());
	}
	
	
	
	
}