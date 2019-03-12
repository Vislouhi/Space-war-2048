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



import java.util.ArrayList;
import java.util.List;

public class DiscreteNumber {
	private List<Integer> digits;
	private int size;
	
	public DiscreteNumber() {
		digits = new ArrayList<>();
	}
	
	public void makeDigit(int d) {
		int number = d;
		while(number>0) {
			digits.add(number%10);
			number/=10;
		}
		size=digits.size();
		
	}
	
	public int get(int i) {
		return digits.get(i);
		
		
		
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		for (Integer i:digits) {
			System.out.println("digit "+i);
		}
	}

}
