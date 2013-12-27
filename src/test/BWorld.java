
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BWorld {
	public String[] seeds = {"moon","earth","halo","metroid"};
	public int[] nSums = {1,5,10};
	public int[] minPeriod = {10,100};
	public int[] maxPeriod = {1000,10000};
	public int[] areaInit = {-500,0,78000};
	public int[] areaLenght =  {1000};
	public int[] sampleRate = {1,10};
	
	public static void main(String[] args){
		BWorld test = new BWorld();
		String dirBaseName = "C:\\Users\\bor\\eclipse\\workspace\\EndlessWorldCreator\\tests\\world class\\";
		String dirFullName = dirBaseName + "Set of worlds at "+utilities.Date.getCurrentTime();
		System.out.println(dirFullName);
		utilities.IO.createDir(dirFullName);
		for(String seed:test.seeds){
			for(int mPeriod:test.minPeriod){
				for(int MPeriod:test.maxPeriod){
					for(int area:test.areaInit){
						for(int lenght:test.areaLenght){
							for(int sample:test.sampleRate){
								PrintWriter writer;
								String fileName = "seed = "+seed+" period = "+mPeriod+" to "+MPeriod+" init = "+area+" length = "+lenght+ " sample = " + sample;
								System.out.println(fileName);
								try {
									writer = new PrintWriter(dirFullName+"\\"+fileName+".txt", "UTF-8");
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
}
