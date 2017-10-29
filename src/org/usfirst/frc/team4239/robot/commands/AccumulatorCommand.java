package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AccumulatorCommand extends Command {

	Boolean up;
	
    public AccumulatorCommand(boolean up) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.up = up; 
    	setTimeout(5);
    	requires(Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(up){
    		Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kReverse);
    	}else{
    		Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kForward);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.setSolenoid(DoubleSolenoid.Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
