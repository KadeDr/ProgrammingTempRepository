package frc.robot.teleop;

// import wpilib imports
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;

// import rev imports

public class Algae {

  // Variables
    /*
    Motor Controllers
    */

  private Spark m_rotationMotor;
  private Encoder m_rotationEncoder;
  private PIDController m_rotationPID;

  private double intakePosition = 1;
  private double outakePosition = 0;

  public void Initialize()
  {
    m_rotationMotor = new Spark(0);
    m_rotationEncoder = new Encoder(0, 1);
    m_rotationPID = new PIDController(0.1, 0.0, 0.0, encoder, motor);
  }

  public void ChangePosition(double newPosition)
  {
    m_rotationPID.setSetpoint(newPosition);

    m_rotationPID.enable();
  }
  
  public void Intake() {
    // Spins the motors in the negative direction to intake the ball
    ChangePosition(intakePosition);
  }

  public void Outake() {
    // Sets the position of the elevator to the correct position in case of incorrect positioning
    // Spins the motors in the positive direction to outake the ball
    ChangePosition(outakePosition);
  }
  
}
