package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Timer;

public class AutoMidToLeft {
	//when the boiler is on right and starting from inner line of overflow loading station

	
	public AutoMidToLeft() {
		while (DriveSubsystem.leftEncoder.getDistance() < 238)//halfway to airship
		{
				Robot.driveSubsystem.set(0.3, 0.3);
		}
		Robot.driveSubsystem.set(-0.1,  -0.1);//slow down
		Timer.delay(0.3);
			
		Robot.driveSubsystem.set(0,0);//stop
		Robot.driveSubsystem.turnToHeading(90);//turn left 90 degrees
			
	    DriveSubsystem.leftEncoder.reset();
	    DriveSubsystem.rightEncoder.reset();
	    
	    while (DriveSubsystem.leftEncoder.getDistance() < 150.546)//driving parallel to base line until at outer of key's tape
		{
				Robot.driveSubsystem.set(0.3, 0.3);
		}
		Robot.driveSubsystem.set(-0.1,  -0.1);//slow down
		Timer.delay(0.3);
			
		Robot.driveSubsystem.set(0,0);//stop
		Robot.driveSubsystem.turnToHeading(0);
		
		DriveSubsystem.leftEncoder.reset();
	    DriveSubsystem.rightEncoder.reset();
	    
		while (DriveSubsystem.leftEncoder.getDistance() < 240)//up to base line
		{
				Robot.driveSubsystem.set(0.3, 0.3);
		}
		Robot.driveSubsystem.set(-0.1,  -0.1);//slow down
		Timer.delay(0.3);
			
		Robot.driveSubsystem.set(0,0);//stop
		Robot.driveSubsystem.turnToHeading(- 60);//turn right 60 degrees
		
		while (DriveSubsystem.leftEncoder.getDistance() < 90)//THEORETICALLY AT LIFT - NEED TO CHECK
		{
				Robot.driveSubsystem.set(0.3, 0.3);
		}
		
		 Robot.driveSubsystem.set(-0.1,  -0.1);
		    Timer.delay(0.3);
		    Robot.driveSubsystem.set(0.0, 0.0);
			Timer.delay(3.3); // time for pilot to pick up gear
			DriveSubsystem.leftEncoder.reset();
			DriveSubsystem.rightEncoder.reset();
			
			while (DriveSubsystem.leftEncoder.getDistance() > -100)
			 Robot.driveSubsystem.set(-0.3, -0.3);//back up so won't run into side, back up 80cm
			

			Robot.driveSubsystem.turnToHeading(0);
			
			DriveSubsystem.leftEncoder.reset();
			DriveSubsystem.rightEncoder.reset();
			
			while (DriveSubsystem.leftEncoder.getDistance() < 80)
			 Robot.driveSubsystem.set(0.3,  0.3);
			
			Robot.driveSubsystem.set(-0.1, -0.1);
			Robot.driveSubsystem.set(0.0,0.0);
		//questionable to shoot into boiler from this range because of potential red/yellow card
		//might be safer to just stay past the base line and refrain from shooting.
			//instead - maybe slam into hopper to empty it out in autonomous bc of extra time
		


	}
}
