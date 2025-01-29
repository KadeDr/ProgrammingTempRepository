package frc.robot.teleop;

// import wpilib imports
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Encoder;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

// import rev imports

public class Algae {

  // Variables
    /*
    Motor Controllers
    */

  private SparkMax m_rotationMotor;
  private Encoder m_rotationEncoder;
  private PIDController m_rotationPID;

  private SparkMax m_intakeMotor;

  public void Initialize()
  {
    m_rotationMotor = new SparkMax(9, MotorType.kBrushless);
    m_rotationEncoder = new Encoder(0, 1);
    m_rotationPID = new PIDController(0.1, 0.0, 0.0, encoder, motor);

    m_intakeMotor = new SparkMax(10, MotorType.kBrushless);
  }

  public void ChangePosition(double newPosition)
  {
    m_rotationPID.setSetpoint(newPosition);

    m_rotationPID.enable();
  }

  public void SpinIntake(double direction)
  {
    m_intakeMotor.set(direction);
  }
  
  public void Intake(double direction, double newPosition)
  {
    ChangePosition(newPosition);
    SpinIntake(direction);
  }
  
}
