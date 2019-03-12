package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	private SimpleDateFormat mounthDataFormat;
	private SimpleDateFormat dayDataFormat;
	private int[] dat = new int[3];
	public DateConverter() {
		 mounthDataFormat = new SimpleDateFormat("M");
		 dayDataFormat = new SimpleDateFormat("dd");
	}
	
	public int[] getDate(long d) {
		
		Date date = new Date(d);
		
		dat[2]=Integer.parseInt(mounthDataFormat.format(date ))-1;
		dat[0]=Integer.parseInt(dayDataFormat.format(date ).substring(0, 1));
		dat[1]=Integer.parseInt(dayDataFormat.format(date ).substring(1, 2));
		return dat;
		
	}

}
