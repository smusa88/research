/**
 * Created by Sead Musa 20/11/2016
 */

import java.sql.Timestamp;
import java.util.Date;

public class Utility {

	public static int getLast15Minute(Date a)
	{
		Timestamp timestamp1 = new Timestamp(a.getTime());
		// create a  second time stamp
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

		// get time difference in seconds
		long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		int seconds = (int) milliseconds / 1000;

		// calculate hours minutes and seconds
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = (seconds % 3600) % 60;

		return minutes;
	}

}
