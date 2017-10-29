
package org.usfirst.frc.team4239.robot;

import org.usfirst.frc.team4239.robot.commands.Auto1;
import org.usfirst.frc.team4239.robot.commands.Auto2;
import org.usfirst.frc.team4239.robot.commands.Auto3;
import org.usfirst.frc.team4239.robot.commands.Auto4;
import org.usfirst.frc.team4239.robot.subsystems.Chassis;
import org.usfirst.frc.team4239.robot.subsystems.PneumaticsSystem;
import org.usfirst.frc.team4239.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Chassis chassis;
	public static PneumaticsSystem pneumatics;
	public static Shooter shooter;
	CameraServer server;
	
	//PREFERENCES
	Preferences prefs;
	
	public static Double sensitivity;
	public static Double turnSensitivity;
	public static Double shootSpeed = 0.6;
	
	//AUTONOMOUS
	Command autonomousCommand;
	SendableChooser autoChooser;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		chassis = new Chassis();
		pneumatics = new PneumaticsSystem();
		shooter = new Shooter();
		
		oi = new OI();
		
		//setup camera
		server = CameraServer.getInstance();
	
		
		//setup autonomous
		autoChooser = new SendableChooser();
		autoChooser.addDefault("auto1", new Auto1());
		autoChooser.addObject("auto2", new Auto2());
		autoChooser.addObject("auto3", new Auto3());
		autoChooser.addObject("auto4", new Auto4());
		SmartDashboard.putData("Autonomous Mode", autoChooser);

		//subsystem data
		//SmartDashboard.putData(Scheduler.getInstance());
		//SmartDashboard.putData(new Chassis());
		//SmartDashboard.putData(new Shooter());
		//SmartDashboard.putData(new PneumaticsSystem());
		
		//setup preferences
		prefs = Preferences.getInstance();
		sensitivity = prefs.getDouble("sensitivity", 1.0);
		turnSensitivity = prefs.getDouble("turn-sensitivity", 1.0);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
       autonomousCommand = (Command) autoChooser.getSelected();
       if(autonomousCommand != null){
    	   autonomousCommand.start();
       }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("REVERSE", oi.controller.getRawButton(1));
        SmartDashboard.putBoolean("Shooter", Robot.shooter.isOn());
        SmartDashboard.putNumber("Sensitivity", sensitivity);
        SmartDashboard.putNumber("Shoot Speed", shootSpeed);
        SmartDashboard.putNumber("Turn Sensitivity", turnSensitivity);
        Timer.delay(0.00001);
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
