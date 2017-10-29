package org.usfirst.frc.team4239.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int rearLeft = 0,
						frontLeft = 1,
						frontRight = 2,
						rearRight = 3,
						roller = 4,
						shooter = 5;
	
	public static int solenoidReverse1 = 0,
						solenoidForward1 = 1,
						solenoidReverse2 = 2,
						solenoidForward2 = 3;
					  
	public static int compressor = 1;
	
}
