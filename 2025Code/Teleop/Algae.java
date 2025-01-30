package frc.robot.teleop;

// import wpilib imports
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;

// import rev imports
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Algae {
  private SparkMax m_rotationMotor;
  private Encoder m_rotationEncoder;
  private PIDController m_rotationPID;

  private SparkMax m_intakeMotor;

  public void Initialize()
  {
    m_rotationMotor = new SparkMax(9, MotorType.kBrushless);
    m_rotationEncoder = new Encoder(0, 1);
    m_rotationPID = new PIDController(0.1, 0.0, 0.0);

    m_intakeMotor = new SparkMax(10, MotorType.kBrushless);
  }

  public void ChangePosition(double newPosition)
  {
    m_rotationPID.setSetpoint(newPosition);
  }

  public void SpinIntake(double direction)
  {
    m_intakeMotor.set(Math.max(-1, Math.min(1, direction)));
  }
  
  public void Intake(double direction, double newPosition)
  {
    ChangePosition(newPosition);
    SpinIntake(direction);
  }

  public void UpdatePIDControl()
  {
    double output = m_rotationPID.calculate(m_rotationEncoder.getDistance());
    m_rotationMotor.set(output);
  } 
}
