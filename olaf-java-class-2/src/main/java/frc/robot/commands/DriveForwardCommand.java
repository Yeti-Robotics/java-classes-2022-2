package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class DriveForwardCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;

    private final Timer timer;
    private final double seconds;

    public DriveForwardCommand(DrivetrainSubsystem drivetrainSubsystem, double seconds) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        this.seconds = seconds;
        this.timer = new Timer();
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        drivetrainSubsystem.tankDrive(0.5, 0.5);
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(seconds);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrainSubsystem.stopDrive();
    }
}
