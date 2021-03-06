package org.usfirst.frc.team5472.robot.commands;

import org.usfirst.frc.team5472.robot.Robot;
import org.usfirst.frc.team5472.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystickCommand extends Command {

	private Joystick j;

	public DriveWithJoystickCommand() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		j = Robot.oi.getJoystick();
	}

	@Override
	protected void execute() {
		double throttle = j.getY();
		double twist = j.getTwist() / 2.0;

		Robot.driveSubsystem.drive(throttle - twist, throttle + twist);

		if (j.getRawButton(RobotMap.shiftGearButton)) {
			Robot.driveSubsystem.setHighGear(true);
		} else {
			Robot.driveSubsystem.setHighGear(false);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.driveSubsystem.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
