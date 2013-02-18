# Using the AS5145B magnetic encoder to get the absolute position of a shaft via PWM filtered thorough a low-pass filter taken as Analog input with the WPILIB

(may be useful for other magnetic encoders)

The determined angle is persistent through powering on and off the encoder 

 See the [datasheet](http://www.ams.com/eng/content/download/50206/533867/34237)([source](http://www.ams.com/eng/Products/Magnetic-Position-Sensors/Magnetic-Rotary-Position-Sensors/AS5145B)) for additional guidance(creating a low-pass filter):
 
 
### Wiring
 * One wire connected to a ground(GND pin) on the magnetic encoder to the analog breakout gnd(-) 
 * One wire going from the analog breakout power(pwr) to the 5v pin on the encoder
 * One wire going from the PWM pin on the encoder to a low-pass filter to change the PWM output to analog and then from the low pass filter to the desired channel on the analog breakout on the cRIO
 
####Optional Wiring

 One wire to each the Mag DECn pin and the Mag INCn to a pin on the digital sidecar for. This tests weather the magnet 

 See section 4.1 of the manual for pin descriptions 
