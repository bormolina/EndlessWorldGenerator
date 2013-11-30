
package utilities;

public class Chrono {
	public long initTime = -1;
	public long endTime = -1;
	public double time;
	
	public double stop(){
		this.endTime = System.nanoTime();
		this.time = (this.endTime-this.initTime)/1000.0/1000.0/1000.0;
		return this.time;
	}
	
	public void start(){
		this.initTime=System.nanoTime();
	}
	
}
