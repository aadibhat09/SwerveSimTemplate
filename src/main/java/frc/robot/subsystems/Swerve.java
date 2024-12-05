package frc.robot.subsystems;

import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swerve extends SubsystemBase {
    private FlywheelSim driveSim = new FlywheelSim(DCMotor.getNEO(1), 1, 0.02931);
    private FlywheelSim turnSim = new FlywheelSim(DCMotor.getNEO(1), 1, 0.04);

    private double turnPositionRad = 0;

    public Swerve() {}

    @Override
    public void periodic() {

        double dt = 0.02;
        driveSim.update(dt);
        turnSim.update(dt);

        turnPositionRad += turnSim.getAngularVelocityRadPerSec() * dt;

        turnPositionRad = turnPositionRad % (2 * Math.PI);
        if (turnPositionRad < 0) {
            turnPositionRad += 2 * Math.PI;
        }

        SmartDashboard.putNumber("Drive Speed (rad/s)", driveSim.getAngularVelocityRadPerSec());
        SmartDashboard.putNumber("Turn Position (rad)", turnPositionRad);
    }

    public void setDriveVoltage(double volts) {
        driveSim.setInputVoltage(volts);
    }

    public void setTurnVoltage(double volts) {
        turnSim.setInputVoltage(volts);
    }
}
