package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.PimpWheelsUp;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PimpWheels extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Compressor compressor = new Compressor(RobotMap.compressor);
	private DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoidForward2, RobotMap.solenoidReverse2);
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new PimpWheelsUp());
    }
	
	public void stop() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void up() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void down() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void startCompressor() {
		compressor.setClosedLoopControl(true);
	}
	
	public void stopCompressor() {
		compressor.setClosedLoopControl(false);
	}
}

