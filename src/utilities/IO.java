
package utilities;

import java.io.File;

public class IO {
	public static void createDir(String fullPath){
		File theDir = new File(fullPath);
		  // if the directory does not exist, create it
		  if (!theDir.exists()) {
			  System.out.println(theDir.mkdir());  
		  }
	}
}
