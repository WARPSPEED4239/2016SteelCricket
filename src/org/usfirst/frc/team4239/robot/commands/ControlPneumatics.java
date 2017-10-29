package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ControlPneumatics extends Command {

	boolean accumulatorUp = false;
	
    public ControlPneumatics() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.oi.joystick.getRawButton(3)){
    		Robot.pneumatics.setRoller(1);
    	}else if(Robot.oi.joystick.getRawButton(4)){
    		Robot.pneumatics.setRoller(-1);
    	}else{
    		Robot.pneumatics.setRoller(0);
    	}
    	
    	if(Robot.oi.joystick.getRawButton(7)){
    		Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kReverse);
    		SmartDashboard.putBoolean("Accumulator", false);
    	}else if(Robot.oi.joystick.getRawButton(8)){
    		Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kForward);
    		SmartDashboard.putBoolean("Accumulator", true);
    	}else{
    		Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kOff);
    	}
    	
    	if(Robot.oi.controller.getRawButton(2)){
    		Robot.pneumatics.setSolenoid2(DoubleSolenoid.Value.kReverse);
    		SmartDashboard.putBoolean("Lift", true);
    	}else
    		Robot.pneumatics.setSolenoid2(DoubleSolenoid.Value.kForward);
    		SmartDashboard.putBoolean("Lift", false);
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
