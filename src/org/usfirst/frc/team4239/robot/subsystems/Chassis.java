package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.Robot;
import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.ChassisArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor frontLeft = new Victor(RobotMap.frontLeft);
	private Victor frontRight = new Victor(RobotMap.frontRight);
	private Victor rearLeft = new Victor(RobotMap.rearLeft);
	private Victor rearRight = new Victor(RobotMap.rearRight);

	RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ChassisArcadeDrive());
    }
    
    public void tankDrive() {
    	drive.setSafetyEnabled(true);
    	drive.tankDrive(-Robot.oi.xbox.getRawAxis(1), -Robot.oi.xbox.getRawAxis(5));
    }
    
    public void arcadeDrive(double move, double rotate){
    	drive.setSafetyEnabled(true);
    	drive.arcadeDrive(move, rotate);
    }
    
    public void setLeftRight(double left, double right) {
    	drive.setLeftRightMotorOutputs(left, right);
    }
    
    public void rotate(double rotate) {
    	drive.setSafetyEnabled(true);
    	drive.arcadeDrive(0, rotate);
    }
    
    public void driveL(double left) {
    	frontLeft.set(-left);
    	rearLeft.set(-left);
    }
    
    public void driveR(double right) {
    	frontRight.set(right);
    	rearRight.set(right);
    }
    
    public void driveLR(double left, double right){
    	drive.setSafetyEnabled(false);
    	drive.setLeftRightMotorOutputs(left, right);
    }
}


 