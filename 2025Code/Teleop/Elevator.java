package frc.robot.teleop

public class Elevator {
  
  private CANSparkMax m_elevatorMotor;
  private SparkPIDController m_pidController;
  private RelativeEncoder m_encoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  private double rotations = 0;

  public void Elevator() {
    m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);
    m_motor.restoreFactoryDefaults();
    m_pidController = m_motor.getPIDController();
    m_encoder = m_motor.getEncoder();

    kP = 0.1; 
    kI = 1e-4;
    kD = 1; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;

    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);
  }
  
  public void SetPosition(float position) {
    m_pidController.setReference(position, CANSparkMax.ControlType.kPosition);
    
    // https://codedocs.revrobotics.com/java/com/revrobotics/absoluteencoder
    
    // It takes 17.9375 rotations of the elevator motor to loop through the full chain

    // 126 chains of movement: 7.875 rotations for max to min

    // TUNING IS VERY IMPORTANT THE MOTOR might die.
    // tuning a pid controller: https://docs.wpilib.org/en/2020/docs/software/advanced-control/introduction/tuning-pid-controller.html
  }
}
