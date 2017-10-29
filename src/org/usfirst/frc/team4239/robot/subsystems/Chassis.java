package org.usfirst.frc.team4239.robot.subsystems;

import org.usfirst.frc.team4239.robot.Robot;
import org.usfirst.frc.team4239.robot.RobotMap;
import org.usfirst.frc.team4239.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor frontLeft = new Victor(RobotMap.frontLeft);
	Victor frontRight = new Victor(RobotMap.frontRight);
	Victor rearLeft = new Victor(RobotMap.rearLeft);
	Victor rearRight = new Victor(RobotMap.rearRight);
	
	RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
    
    
    public void arcadeDrive(){
    	drive.setSafetyEnabled(true);
    	drive.arcadeDrive((Robot.oi.controller.getRawAxis(3)-Robot.oi.controller.getRawAxis(2))*Robot.sensitivity, Robot.oi.controller.getRawAxis(0)*-Robot.turnSensitivity);
    }

    public void reverseArcadeDrive(){
    	drive.setSafetyEnabled(true);
    	drive.arcadeDrive((Robot.oi.controller.getRawAxis(3)-Robot.oi.controller.getRawAxis(2))*-Robot.sensitivity, Robot.oi.controller.getRawAxis(0)*-Robot.turnSensitivity);    	
    }
    
    public void drive(Double speed, Double turn){
    	drive.setSafetyEnabled(true);
    	drive.drive(speed, turn);
    }
    
    public void driveLR(Double left, Double right){
    	drive.setLeftRightMotorOutputs(left, right);
    }
    
}

