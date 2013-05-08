###  Using the AS5145B magnetic encoder to get the absolute position of a shaft via PWM filtered thorough a low-pass filter taken as Analog input with the WPILIB

(may be useful for other magnetic encoders)

The determined angle is persistent through powering on and off the encoder. The pwm output outputs a square wave porportional to the degree of angle of the shaft. The low pass filter is so one can use the pwm output as analog output, where the voltage is porportional to the angle of the shaft. Note, this will introduce some noise; I've been getting around plus or minus 3 degrees of inaccuracy due to noise.

 See the [datasheet](http://www.ams.com/eng/content/download/50206/533867/34237)([source](http://www.ams.com/eng/Products/Magnetic-Position-Sensors/Magnetic-Rotary-Position-Sensors/AS5145B)) for additional guidance(creating a low-pass filter):

### Requirements

* CRIO & Sidecar
* SmartDashboard
* Wiring
* A calibrated magnet mounted on a shaft and aligned to an encoder

The shaft needs to move less than 1 full revolution during its movement. 
The maximum voltage(what I labeled as HEURISTIC_VOLTAGE can be determined by trying to adjust your magnet to near 360 degrees. This will be around 5v. Make sure the ground and the power source are form the same place(Analog breakout)
 
 
### Wiring
 * One wire connected to a ground(GND pin) on the magnetic encoder to the analog breakout gnd(-) 
 * One wire going from the analog breakout power(pwr) to the 5v pin on the encoder
 * One wire going from the PWM pin on the encoder to a low-pass filter to change the PWM output to analog and then from the low pass filter to the desired channel on the analog breakout on the cRIO
 
####Optional Wiring

 One wire to each the Mag DECn pin and the Mag INCn to a pin on the digital sidecar for. This tests weather the magnet 

 See section 4.1 of the manual for pin descriptions 
