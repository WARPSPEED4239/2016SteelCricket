package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.ControlPneumatics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticsSystem extends Subsystem {
	
	Talon roller = new Talon(RobotMap.roller);
	
	Compressor compressor = new Compressor(1);
	DoubleSolenoid solenoid = new DoubleSolenoid(0, 1);
	DoubleSolenoid solenoid2 = new DoubleSolenoid(2, 3);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ControlPneumatics());
    }
    
    public void setRoller(double d){
    	roller.set(d);
    }
    
    public boolean compressorEnabled(){
    	return compressor.enabled();
    }
    
    public void startCompressor(){
    	compressor.setClosedLoopControl(true);
    }
    
    public void stopCompressor(){
    	compressor.setClosedLoopControl(false);
    }
    
    public void setSolenoid(DoubleSolenoid.Value value){
    	solenoid.set(value);
    }
    
    public void setSolenoid2(DoubleSolenoid.Value value){
    	solenoid2.set(value);
    }
}