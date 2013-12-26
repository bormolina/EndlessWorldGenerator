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

import java.io.File;

public class PeriodicFunction {
	/**
	 * Get t-value of a sinus
	 * @param amplitude
	 * @param period
	 * @param phase
	 * @param t
	 * @return
	 */
	public static double periodicSinusWave(double amplitude, double period, double phase, double t){
		double frecuency = 1/period;
		double arg = frecuency*t+phase;
		return amplitude*Math.sin(arg);
	}
	
	/**
	 * Get t-values of triangle wave
	 * @param amplitude
	 * @param period
	 * @param t
	 * @return
	 */
	public static double periodicTriangleWave(double amplitude, double period, double t){
		t%=period;
		double mid = period/2;
		return (1-PeriodicFunction.relativeDistance(mid, t, period)*2)*amplitude;
	}
	
	/**
	 * Distance between two points
	 * @param a
	 * @param b
	 * @return
	 */
	public static double distance(double a, double b){
		return Math.abs(a-b);
	}
	
	public static double relativeDistance(double point1, double point2, double total){
		return PeriodicFunction.distance(point1, point2)/total;
	}
	
	public static void main(String[] args){
		new File("C:\\Users\\bor\\eclipse\\workspace\\EndlessWorldCreator\\borja.txt").delete();
		
		for(double i=0.0;i<10; i+=0.01){
			Log.writeIn("test.txt", Double.toString(PeriodicFunction.periodicTriangleWave(3, 4, i)));
		}
	}
}
