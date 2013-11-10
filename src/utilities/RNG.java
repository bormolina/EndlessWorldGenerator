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

/**
 * Generates random numbers. 
 * This class is independent of the standard class used by java for generate random numbers.
 * It's based on linear congruential generator for more info visit http://en.wikipedia.org/wiki/Linear_congruential_generator
 * @author Borja Molina Zea
 * v0.1
 */

public class RNG {
	private int seed=0;
	public int a = 999999937;
	public int c = 999416681;
	public int max = Integer.MAX_VALUE;
	
	public RNG (int seed){
		this.seed = seed;
	}
	
	/**
	 * Sets the next seed
	 */
	private void nextSeed(){
		this.seed = this.seed*this.a+this.c;
	}
	
	/**
	 * Generates a random number between 0 and 1
	 */
	public double rand(){
		this.nextSeed();
		double n = (double)this.seed/this.max;
		if(n<0){
			n*=-1;
		}
		return n;
	}
	
	/**
	 * Generates a random number between Integer.MIN_VALUE and Integer.MAX_VALUE
	 * @return
	 */
	public int randi(){
		this.nextSeed();
		return this.seed;
	}
	
	/**
	 * Generates a real number in a range [start, end]
	 * @param start
	 * @param end
	 * @return
	 */
	public double randd(double start, double end){
		return start + (end - start)*this.rand(); 
	}
	
	/**
	 * Generates an integer number in the range [start, end]
	 * @param start
	 * @param end
	 * @return
	 */
	public int randi(int start, int end){
		return (int)Math.round(this.randd(start-0.5, end+0.5)); 
	}
	

}
