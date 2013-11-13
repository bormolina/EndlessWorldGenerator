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
/**
 * All the 'random' numbers used for create the world.
 * Starting from a seed-string, like "hola", it generates 2^18 different numbers.
 * Different strings generates different numbers.
 * The numbers are stored in a integer array.
 * v 0.1
 */
package world;

import java.io.IOException;

public class GlobalSeed {
	public String sSeed;
	public int nSeed;
	public int size = 262144;
	public int amplitudeIndex = 0;
	public int amplitudeSize = 128;
	public int frecuencyIndex = amplitudeIndex + amplitudeSize;
	public int frecuencySize = 128;
	public int xPhaseIndex = frecuencyIndex + frecuencySize;
	public int xPasheSize = 128;
	public int zPhaseIndex = xPhaseIndex + xPasheSize;
	public int zPhaseSize = 128;

	public int[] seeds = new int[size] ;
		
	public GlobalSeed(String seed){
		this.sSeed = seed;
		this.nSeed = this.generateNumberSeed();
	}
	
	private int generateNumberSeed(){
		return this.sSeed.hashCode();
	}
	
	public int getGlobal(int index){
		return this.seeds[index];
	}
	
	public int getAmplitude(int index){
		index%=this.amplitudeSize;
		index+=this.amplitudeIndex;
		return this.seeds[index];
	}
	
	public int getFrecuency(int index){
		index%=this.frecuencySize;
		index+=this.frecuencyIndex;
		return this.seeds[index];
	}

	public int xPhase(int index){
		index%=this.frecuencySize;
		index+=this.frecuencyIndex;
		return this.seeds[index];
	}
	
	public int zPhase(int index){
		index%=this.zPhaseSize;
		index+=this.zPhaseIndex;
		return this.seeds[index];
	}
}
