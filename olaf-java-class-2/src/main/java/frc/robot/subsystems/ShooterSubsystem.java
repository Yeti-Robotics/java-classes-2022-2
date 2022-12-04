package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    private final WPI_TalonFX leftMotor, rightMotor;

    public ShooterSubsystem() {
        leftMotor = new WPI_TalonFX(6);
        rightMotor = new WPI_TalonFX(5);

        rightMotor.follow(leftMotor);
        rightMotor.setInverted(InvertType.OpposeMaster);

        leftMotor.setNeutralMode(NeutralMode.Coast);
        rightMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void spinFlywheel(double speed) {
        leftMotor.set(speed);
    }

    public void stopFlywheel() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }
}

