package org.usfirst.frc.team4239.robot;

import org.usfirst.frc.team4239.robot.commands.ArmDown;
import org.usfirst.frc.team4239.robot.commands.ArmUp;
import org.usfirst.frc.team4239.robot.commands.PimpWheelsDown;
import org.usfirst.frc.team4239.robot.commands.RollerIn;
import org.usfirst.frc.team4239.robot.commands.RollerOut;
import org.usfirst.frc.team4239.robot.commands.ShooterSpin;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick xbox;
	public Joystick joystick;
	
	
	public JoystickButton xbutton2,
							
							jbutton1,
							jbutton3,
							jbutton4,
							jbutton7,
							jbutton8;
	
	public OI() {
		xbox = new Joystick (0);
		joystick = new Joystick (1);
		
		xbutton2 = new JoystickButton(xbox, 2);
		
		jbutton1 = new JoystickButton(joystick, 1);
		jbutton3 = new JoystickButton(joystick, 3);
		jbutton4 = new JoystickButton(joystick, 4);
		jbutton7 = new JoystickButton(joystick, 7);
		jbutton8 = new JoystickButton(joystick, 8);
		
		xbutton2.whileHeld(new PimpWheelsDown());
		
		jbutton1.whileHeld(new ShooterSpin());
		jbutton3.whileHeld(new RollerOut());
		jbutton4.whileHeld(new RollerIn());
		jbutton7.whenPressed(new ArmDown());
		jbutton8.whenPressed(new ArmUp());
	}
}
