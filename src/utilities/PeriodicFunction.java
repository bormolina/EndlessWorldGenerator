/*******************************************************************************
 * Copyright (c) 2013 Borja Molina Zea.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Borja Molina Zea - initial API and implementation
 ******************************************************************************/
package utilities;

public class PeriodicFunction {
	public static double periodicSinusWave(double amplitude, double period, double phase, double t){
		double frecuency = 1/period;
		double arg = frecuency*t+phase;
		return amplitude*Math.sin(arg);
	}
}
