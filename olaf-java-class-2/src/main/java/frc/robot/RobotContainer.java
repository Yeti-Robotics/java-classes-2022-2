// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveForwardCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeAllInCommand;
import frc.robot.commands.IntakeAllOutCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    
    private Command autoCommand;
    private final DrivetrainSubsystem drivetrainSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final Joystick driverstation;
    
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        drivetrainSubsystem = new DrivetrainSubsystem();
        driverstation = new Joystick(0);
        intakeSubsystem = new IntakeSubsystem();
        shooterSubsystem = new ShooterSubsystem();

        drivetrainSubsystem.setDefaultCommand(
            new RunCommand(
                () -> drivetrainSubsystem.tankDrive(-driverstation.getRawAxis(0), driverstation.getRawAxis(2)), drivetrainSubsystem));
        // Configure the button bindings
        configureButtonBindings();
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        new JoystickButton(driverstation, 1).whileHeld(new IntakeAllInCommand(intakeSubsystem));
        new JoystickButton(driverstation, 6).whileHeld(new IntakeAllOutCommand(intakeSubsystem));

        new JoystickButton(driverstation, 11)
            .whenPressed(new InstantCommand(
                () -> intakeSubsystem.extend(),
                intakeSubsystem
            ));
        new JoystickButton(driverstation, 12)
            .whenPressed(new InstantCommand(
                () -> intakeSubsystem.retract(),
                intakeSubsystem
            ));

        new JoystickButton(driverstation, 2)
            .whenPressed(new InstantCommand(
                () -> shooterSubsystem.spinFlywheel(0.6),
                shooterSubsystem
            ));
        new JoystickButton(driverstation, 7)
            .whenPressed(new InstantCommand(
                () -> shooterSubsystem.stopFlywheel(),
                shooterSubsystem
            ));
    }

    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        autoCommand = new SequentialCommandGroup(
            new InstantCommand(
                () -> intakeSubsystem.extend(),
                intakeSubsystem
            ),
            new IntakeAllInCommand(intakeSubsystem).withTimeout(5.0).
                alongWith(new DriveForwardCommand(drivetrainSubsystem, 5.0)),
            new InstantCommand(
                () -> shooterSubsystem.spinFlywheel(0.85),
                shooterSubsystem
            ),
            new WaitCommand(1.0),
            new InstantCommand(
                () -> intakeSubsystem.retract(),
                intakeSubsystem
            ),
            new IntakeAllInCommand(intakeSubsystem).withTimeout(5.0),
            new InstantCommand(
                () -> shooterSubsystem.stopFlywheel(),
                shooterSubsystem
            )
        );

        return autoCommand;
    }
}
