package frc.robot.teleop;

public class Coral {
  
  private CANSparkMax motor = new CANSparkMax(1, MotorType.kBrushless);
  
  public void CIntake() {
        // Check if X button on PS4 controller is pressed
        if (ps4Controller.getRawButton(1)) { // Button 1 is the "X" button on PS4 controller. Can use(xboxController.getRawButton(1)) for "A" button on xbox controller 
            motor.set(0.5); // Set motor speed to 50% forward
        } else {
            motor.set(0); // If X is not pressed, stop the motor
      }
  }

  public void COuttake() {
    if (ps4Controller.getRawButton(4)) { // Button 1 is the triangle button on PS4 controller. Can use(xboxController.getRawButton(4)) for "Y" button on xbox controller 
      motor.set(-0.5); // Set motor speed to 50% backward
    } else {
      motor.set(0); // If triangle is not pressed, stop the motor
    }
}
