package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * This class is used to test out the AS5145B encodder for absolute input
 * via the pwm out put through a low-pass filter
 * See the datasheet for instructions for wiring:
 * http://www.ams.com/eng/content/download/50206/533867/34237
 * From:
 * http://www.ams.com/eng/Products/Magnetic-Position-Sensors/Magnetic-Rotary-Position-Sensors/AS5145B
 * Wiring:
 * one wire connected to a ground(GND pin) on the magnetic encoder to the analog breakout gnd(-)
 * one wire going from the analog breakout power(pwr) to the 5v pin on the encoder
 * one wire going from the PWM pin on the encoder to a low-pass filter to change the PWM output to analog and then from the low pass filter to the desired channel on the analog breakout on the cRIO
 * optional wiring:
 * one wire to each the Mag DECn pin and the Mag INCn for testing to a pin on the digital sidecar 
 * see section 4.1 of the manual for pin descriptions 
 * 
 * 
 */
public class RobotTemplate extends SimpleRobot {

    DigitalInput magdec = new DigitalInput(4);
    DigitalInput maginc = new DigitalInput(3);
    AnalogChannel absAngle = new AnalogChannel(1);
    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(true) {
            // output voltage is ~4.1v. Conversion
            double angle = absAngle.getVoltage() * 360/4.9; 

            SmartDashboard.putBoolean("maginc", maginc.get());
            SmartDashboard.putBoolean("magdec", magdec.get());
            SmartDashboard.putNumber("voltage", absAngle.getVoltage());
            SmartDashboard.putNumber("angle", angle);
            System.out.println("voltage:" + absAngle.getVoltage());
        }

    }
}
