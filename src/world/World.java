/**
 * This class is in a very early stage of development
 * v0.1
 */

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
package world;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import world.GlobalSeed;
import utilities.Chrono;
import utilities.PeriodicFunction;

public class World {
	public String seed;
	public GlobalSeed seeds;
	public double minPeriod = 100;
	public double maxPeriod = 10000;
	public double maxAmplitude = 100;
	public double maxPhase =2*Math.PI*maxPeriod;
	PrintWriter writer;
	
	public World(String seed) throws FileNotFoundException, UnsupportedEncodingException{
		this.seed = seed;
		this.seeds = new GlobalSeed(this.seed);
		this.writer = new PrintWriter("C:\\Users\\bor\\eclipse\\workspace\\EndlessWorldCreator\\tests\\outputfile.txt", "UTF-8");
	}
	
	public double getPeriod(int index){
		double period = this.seeds.getPeriod(index);
		if(period<0){
			period*=-1;
		}
		return this.minPeriod +(period%(this.maxPeriod-this.minPeriod));
	}
	
	public double getAmplitude(int index){
		double amplitude = this.seeds.getAmplitude(index);
		if(amplitude<0){
			amplitude*=-1;
		}
		return (amplitude%this.maxAmplitude);
	}
	
	public double getxPhase(int index){
		double phase = this.seeds.getxPhase(index);
		if(phase<0){
			phase*=-1;
		}
		return (phase%this.maxPhase);
	}
	
	public double getzPhase(int index){
		double phase = this.seeds.getzPhase(index);
		if(phase<0){
			phase*=-1;
		}
		return (phase%this.maxPhase);
	}
	
	/**
	 * 	ESTA FUNCION LA QUIERO SEPARAR, CREAR UNA SUBFUNCION QUE SEA
	 * GETELEVATION(X,Z, INT I) que coja la elevación de x,z en la dimensión y
	 */
	public double getElevation(int x, int z, int i){
		double value = 0;
		double amplitude=0;
		double period=0;
		//for(int i=0; i<numSums;i++){
			amplitude = this.getAmplitude(i);
			period = this.getPeriod(i);
			//this.writer.printf("%.2f ", period);
			double xPhase = this.getxPhase(i);
			double zPhase = this.getzPhase(i);
			double xValue = utilities.PeriodicFunction.periodicSinusWave(amplitude, period, xPhase, x);
			double zValue = utilities.PeriodicFunction.periodicSinusWave(amplitude, period, zPhase, z);
			value += xValue + zValue;
			//this.writer.printf("%.2f ", value);
		//}
		return value;
	}
	
	/**
	 * 
	 * @param x
	 * @param z
	 * @param numSums
	 * @return
	 */
	public double getWorldElevation(int x, int z, int numSums){
		double value = 0;
		double amplitude=0;
		double period=0;
		for(int i=0; i<numSums;i++){
			amplitude = this.getAmplitude(i);
			period = this.getPeriod(i);
			//this.writer.printf("%.2f ", period);
			double xPhase = this.getxPhase(i);
			double zPhase = this.getzPhase(i);
			double xValue = utilities.PeriodicFunction.periodicSinusWave(amplitude, period, xPhase, x);
			double zValue = utilities.PeriodicFunction.periodicSinusWave(amplitude, period, zPhase, z);
			value += xValue + zValue;
			//this.writer.printf("%.2f ", value);
		}
		return value;
	}
	
	public void testValues(int numSums){
		double value = 0;
		double amplitude=0;
		double period=0;
		this.writer.printf("Resultados para la semilla '%s'\n",this.seed);
		this.writer.printf("Periodo minimo '%s'\n",this.minPeriod);
		this.writer.printf("Periodo maximo '%s'\n",this.maxPeriod);
		this.writer.printf("Amplitud maxima '%s'\n",this.maxAmplitude);
		this.writer.printf("Fase maxima '%s'\n",this.maxPhase);
		this.writer.printf("Periodos\n",this.seed);
		for(int i=0; i<numSums;i++){
			this.writer.printf("T%d = %.2f\n",i,this.getPeriod(i));
		}
		this.writer.printf("Amplitudes\n",this.seed);
		for(int i=0; i<numSums;i++){
			this.writer.printf("A%d = %.2f\n",i,this.getAmplitude(i));
		}
		this.writer.printf("Fases para la x\n",this.seed);
		for(int i=0; i<numSums;i++){
			this.writer.printf("Px%d = %.2f\n",i,this.getxPhase(i));
		}
		this.writer.printf("Fases para la z\n",this.seed);
		for(int i=0; i<numSums;i++){
			this.writer.printf("Pz%d = %.2f\n",i,this.getzPhase(i));
		}
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException{
		World tierra = new World("moon");
		System.out.printf("Comienzo\n");
		Chrono c = new Chrono();
		c.start();
		//tierra.testValues(20);
		for(int x=-500; x<500; x++){
			for(int z=-500; z<500; z++){
				double h = tierra.getWorldElevation(x, z, 5);
				tierra.writer.printf("%.2f ", h);
			}
			tierra.writer.println();
		}
		tierra.writer.close();
		double t = c.stop();
		System.out.printf("He acabado en %f segundos",t);
	}
	
}
