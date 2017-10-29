package org.usfirst.frc.team4239.robot.commands;

import org.usfirst.frc.team4239.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionProcAimAssist extends Command {

	double timeout = 5;
	NetworkTable table;
	double[] defaultValue = new double[0];
	double[] centerXs;
	int cameraWidth = 640;
	int cameraMiddle = cameraWidth/2;
	double distanceFromMiddle;
	boolean isAlligned = false;
	double speed;
	
    public VisionProcAimAssist() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	setTimeout(timeout);
    	table.setClientMode();
    	table.setIPAddress("10.42.39.1");
    	table = NetworkTable.getTable("GRIP/myContoursReport");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	centerXs = table.getNumberArray("centerX", defaultValue);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	distanceFromMiddle = Math.abs(centerXs[0]-cameraMiddle);
    	speed = 0.00002*(centerXs[0]/cameraMiddle);
    	Robot.chassis.driveLR(speed, -speed);
    	
    	if(distanceFromMiddle < 20){
    		isAlligned = true;
    	}else{
    		isAlligned = false;
    	}
    	SmartDashboard.putBoolean("Is Alligned", isAlligned);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || isAlligned;
    }

    // Called once after isFinished returns true
    protected void end() {
		isAlligned = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
