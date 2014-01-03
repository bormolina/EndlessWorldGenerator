
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import world.World;

public class BWorld {
	public String[] seeds = {"moon","earth"};
	public int[] nSums = {1,5,10};
	public int[] minPeriod = {10,100};
	public int[] maxPeriod = {1000,10000};
	public int[] areaInit = {-250,0};
	public int[] areaLenght =  {500};
	public int[] sampleRate = {1,10};
	
	public static void main(String[] args){
		BWorld test = new BWorld();
		String dirBaseName = "C:\\Users\\bor\\eclipse\\workspace\\EndlessWorldCreator\\tests\\world class\\";
		String dirFullName = dirBaseName + "Set of worlds at "+utilities.Date.getCurrentTime();
		System.out.println(dirFullName);
		utilities.IO.createDir(dirFullName);
		for(String seed:test.seeds){
			//World tierra = new World(seed);
			for(int mPeriod:test.minPeriod){
				for(int MPeriod:test.maxPeriod){
					World tierra = new World(seed,mPeriod,MPeriod);
					for(int area:test.areaInit){
						for(int lenght:test.areaLenght){
							for(int numSums:test.nSums){
								for(int sample:test.sampleRate){
									PrintWriter writer;
									String fileName = "seed = "+seed+" period = "+mPeriod+" to "+MPeriod+" init = "+area+" length = "+lenght+ " nSums = "+numSums+" sample = " + sample;
									System.out.println(fileName);
									try {
										writer = new PrintWriter(dirFullName+"\\"+fileName+".txt", "UTF-8");
										
										for(int x=area; x<area+lenght; x+=sample){
											for(int z=area; z<area+lenght; z+=sample){
												double h = tierra.getWorldElevation(x, z, numSums);
												//tierra.writer.printf("%.2f ", h);
												writer.printf("%.2f ",h);
											}
											writer.println();
											//tierra.writer.println();
										}
										writer.close();
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (UnsupportedEncodingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("finalizado");
	}
}
