
package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
	/**
	 ** @return Current time in a String
	 */
	public static String getCurrentTime(){
		String DATE_FORMAT_NOW = "yyyy MM dd---HH.mm.ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
}
