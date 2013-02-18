# Using the AS5145B as an Absolute Encoder via PWM filtered thorough a low-pass filter taken as Analog input

(may be useful for other magnetic encoders)

 This class is used to test out the AS5145B encodder for absolute input
 via the pwm out put through a low-pass filter
 See the [datasheet](http://www.ams.com/eng/content/download/50206/533867/34237)([source](http://www.ams.com/eng/Products/Magnetic-Position-Sensors/Magnetic-Rotary-Position-Sensors/AS5145B)) for instructions for wiring:
 
 
### Wiring
 one wire connected to a ground(GND pin) on the magnetic encoder to the analog breakout gnd(-)

 one wire going from the analog breakout power(pwr) to the 5v pin on the encoder

 one wire going from the PWM pin on the encoder to a low-pass filter to change the PWM output to analog and then from the low pass filter to the desired channel on the analog breakout on the cRIO

 ####optional wiring:
 one wire to each the Mag DECn pin and the Mag INCn for testing to a pin on the digital sidecar 
 see section 4.1 of the manual for pin descriptions 
