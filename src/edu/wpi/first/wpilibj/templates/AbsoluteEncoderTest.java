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
public class AbsoluteEncoderTest extends SimpleRobot {

    // these inputs are to test weather the magnetic encoder is in the correct field.
    // These don't need to be used.
    static final int MAGNETIC_FIELD_DECREASING_TEST = 4;
    static final int MAGNETIC_FIELD_INCREASING_TEST = 3;
    DigitalInput magdec = new DigitalInput(MAGNETIC_FIELD_DECREASING_TEST);
    DigitalInput maginc = new DigitalInput(MAGNETIC_FIELD_INCREASING_TEST);

    // Find the output foltage from the low-pass filter from the pwm out
    static final int ABSOLUTE_ENCODER_CHANNEL = 1;
    AnalogChannel absAngle = new AnalogChannel(ABSOLUTE_ENCODER_CHANNEL);
    
    static final double HEURISTIC_VOLTAGE = 4.9;

    public void operatorControl() {
        while(true) {
            // output voltage is ~4.9v. Conversion to angle
            // If the max voltage doesn't give 360 degrees, then the heuristic voltage is wrong
            double angle = absAngle.getVoltage() * 360/HEURISTIC_VOLTAGE; 

            SmartDashboard.putBoolean("maginc", maginc.get());
            SmartDashboard.putBoolean("magdec", magdec.get());
            SmartDashboard.putNumber("voltage", absAngle.getVoltage());
            SmartDashboard.putNumber("angle", angle);
            System.out.println("voltage:" + absAngle.getVoltage());
            System.out.println("angle:" + angle);

        }

    }
}
