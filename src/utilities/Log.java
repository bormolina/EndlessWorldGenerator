
package utilities;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
	public static void writeIn(String fileName, String data){
		try
		{
		    FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
		    fw.write(data+"\n"); 
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
}
