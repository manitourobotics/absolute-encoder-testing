/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

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
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
