package frc.robot.commands;

import frc.robot.subsystems.Swerve;
import edu.wpi.first.wpilibj2.command.Command;

public class SwerveCommand extends Command{
    private final Swerve swerveSubsystem;
    private final double driveVoltage;
    private final double turnVoltage;

    public SwerveCommand(Swerve swerveSubsystem, double driveVoltage, double turnVoltage) {
        this.swerveSubsystem = swerveSubsystem;
        this.driveVoltage = driveVoltage;
        this.turnVoltage = turnVoltage;

        // Declare subsystem dependencies
        addRequirements(swerveSubsystem);
    }

    
    public void initialize() {
        System.out.println("[Command] SwerveDriveCommand initialized");
    }

    public void execute() {
        // Apply the voltages to the drive and turn motors
        swerveSubsystem.setDriveVoltage(driveVoltage);
        swerveSubsystem.setTurnVoltage(turnVoltage);
    }

    public void end(boolean interrupted) {
        // Stop applying voltages
        swerveSubsystem.setDriveVoltage(0);
        swerveSubsystem.setTurnVoltage(0);
        System.out.println("[Command] SwerveDriveCommand ended");
    }

    public boolean isFinished() {
        // Run until explicitly canceled
        return false;
    }
}
