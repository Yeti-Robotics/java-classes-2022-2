package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
    private final WPI_TalonFX leftMotor1, leftMotor2, rightMotor1, rightMotor2;
    private final DifferentialDrive differentialDrive;

    public DrivetrainSubsystem() {
        leftMotor1 = new WPI_TalonFX(1);
        leftMotor2 = new WPI_TalonFX(4);
        rightMotor1 = new WPI_TalonFX(3);
        rightMotor2 = new WPI_TalonFX(2);

        differentialDrive = new DifferentialDrive(leftMotor1, rightMotor1);
        differentialDrive.setDeadband(0.05);

        leftMotor1.setInverted(false);
        rightMotor1.setInverted(true);

        leftMotor2.follow(leftMotor1);
        leftMotor2.setInverted(InvertType.FollowMaster);
        rightMotor2.follow(rightMotor1);
        rightMotor2.setInverted(InvertType.FollowMaster);
    }

    public void tankDrive(double leftPower, double rightPower) {
        differentialDrive.tankDrive(leftPower, rightPower);
    }

    public void stopDrive() {
        leftMotor1.set(0.0);
        rightMotor1.set(0.0);
    }
}

