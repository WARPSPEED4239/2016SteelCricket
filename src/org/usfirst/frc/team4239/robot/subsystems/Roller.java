package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.RollerStop;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor roller = new Victor(RobotMap.roller);
	//private double rollSpeed;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	//rollSpeed = SmartDashboard.getNumber("roll", 1.0);
        setDefaultCommand(new RollerStop());
    }
    
    public void stop() {
    	roller.set(0);
    }
    
    public void in() {
    	roller.set(-1);
    	//rollSpeed = SmartDashboard.getNumber("roll");
    	//roller.set(rollSpeed);
    }
    
    public void out() {
    	roller.set(1);
    }
}

