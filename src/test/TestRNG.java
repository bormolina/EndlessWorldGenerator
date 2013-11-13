package test;
import java.util.Arrays;
import java.util.Collection;
 



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 

@RunWith(value = Parameterized.class)
public class TestRNG {
 
	 private int seed;
	 private utilities.RNG rn;
	 private int iters = 100 * 100;
	  
	 public TestRNG(int seed, int n2) {
	    this.seed = seed;
	    this.rn = new utilities.RNG(this.seed);
	 }
 
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
			   							{ 0 , 1 },
			   							{ 1 ,2 }, 
			   							{ 77734892, 1 },
			   							{ 77734893, 1 }, 
			   							{ -222, 1 }, 
			   							{ -223, 2 } };
	   return Arrays.asList(data);
	 }
 
	 @Before
	 public void init(){
		 //System.out.println("Semilla: "+this.seed);
		 this.rn = new utilities.RNG(this.seed);
	 }
	 
	 @After
	 public void end(){
		 System.out.println("#### FIN del test ###: "+this.seed+"\n\n");
	 }
	 
	 /**
	  * Comprobamos que cuando generamos un aleatorio entre 0 y 1
	  * La mitad de las veces(aprox) está por debajo de 0.5
	  */
	 @Test
	 public void rand() {
		 System.out.println("Test rand");
		 int sum=0;
		 for(int i=0;i<this.iters;i++){
			double n = this.rn.rand();
			if(n<0.5){
				sum++;
			} 
		 }
		 System.out.println("Esta por debajo en un "+(sum*1.0/this.iters*100) +"% de las veces");
	 }
 
	
	 /**
	  * Comprobamos que cuando generamos un entero n en el intervalor [a,b], ese n es generado con una probabilidad de
	  * 1/(b-a+1)
	  **/
	 @Test 
	 public void randi(){
		 System.out.println("Test randi");
		 int sum=0;
		 int inicio = -1;
		 int fin = 1;
		 int tam = fin-inicio+1;
		 int ele = 1;
		 for(int i=0;i<this.iters;i++){
			double n = this.rn.randi(inicio,fin);
			if(n==0){
				sum++;
			} 
		 }
		 System.out.println("Se cumple en "+(sum*1.0/iters)*100 +" y debería: "+(1.0/tam)*100); 
	 }
}