package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final DoubleSolenoid intakePiston;

    private final VictorSPX conveyorMotor;
    private final VictorSPX intakeMotor;

    public IntakeSubsystem() {
        this.intakePiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 7, 0);
        this.conveyorMotor = new VictorSPX(9);
        this.intakeMotor = new VictorSPX(8);

        intakeMotor.setInverted(true);
        conveyorMotor.setInverted(true);

        retract();
    }

    public void extend() {
        intakePiston.set(DoubleSolenoid.Value.kForward);
    }

    public void retract() {
        intakePiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void spinConveyorIn(double speed) {
        conveyorMotor.set(ControlMode.PercentOutput, Math.abs(speed));
    }

    public void spinConveyorOut(double speed) {
        conveyorMotor.set(ControlMode.PercentOutput, Math.copySign(speed, -1.0));
    }

    public void spinIntakeIn(double speed) {
        intakeMotor.set(ControlMode.PercentOutput, Math.abs(speed));
    }

    public void spinIntakeOut(double speed) {
        intakeMotor.set(ControlMode.PercentOutput, Math.copySign(speed, -1.0));
    }

    public void stopMotors() {
        conveyorMotor.set(ControlMode.PercentOutput, 0.0);
        intakeMotor.set(ControlMode.PercentOutput, 0.0);
    }
}

