
package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import world.World;

public class TestWorld {
	
	private World earth; 
	int nSums;
	
	public TestWorld() throws FileNotFoundException, UnsupportedEncodingException{
		this.earth = new World("sun");
		this.nSums = 40;
	}
	
	 @Test
	 public void inRange() {
		 for(int i=0; i<this.nSums; i++){
			 assertTrue("Fallo en amplitud",this.earth.getAmplitude(i)<=this.earth.maxAmplitude);
			 assertTrue("Fallo en periodo, más grande de lo debido",this.earth.getPeriod(i)<=this.earth.maxPeriod);
			 assertTrue("Fallo en periodo, más pequeño de lo debido",this.earth.getPeriod(i)>=this.earth.minPeriod);
			 assertTrue("Fallo en faseX",this.earth.getxPhase(i)<=this.earth.maxPhase);
			 assertTrue("Fallo en faseZ",this.earth.getzPhase(i)<=this.earth.maxPhase);

		 }
	 }
}
