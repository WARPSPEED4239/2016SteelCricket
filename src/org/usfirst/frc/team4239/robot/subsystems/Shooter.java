package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.Robot;
import org.usfirst.frc.team4239.robot.RobotMap;


import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    static // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon wheel = new Talon(RobotMap.wheel);

	static boolean shooterOn = false;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static void toggleShooter(){
    	if(shooterOn){
    		wheel.set(0);
    		shooterOn = false;
    	}else{
    		wheel.set(Robot.shootSpeed);
    		shooterOn = true;
    	}
    }
    
    public static boolean isOn(){
    	return shooterOn;
    }
    
    public static void setWheel(double d){
    	wheel.set(d);
    }
    
    public static void stopWheel(){
    	wheel.set(0);
    }
    
    public static Talon getShooter(){
    	return wheel;
    }
}

