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


package test;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.imageio.ImageIO;


public class TextureMaker {
	
	public TextureMaker() {
		List<String> monthes = new ArrayList<>();
		monthes.add("Jan");
		monthes.add("Feb");
		monthes.add("Mar");
		monthes.add("Apr");
		monthes.add("May");
		monthes.add("Jun");
		monthes.add("Jul");
		monthes.add("Aug");
		monthes.add("Sep");
		monthes.add("Oct");
		monthes.add("Nov");
		monthes.add("Dec");
		
		List<String> digits = new ArrayList<>();
		digits.add("0");
		digits.add("1");
		digits.add("2");
		digits.add("3");
		digits.add("4");
		digits.add("5");
		digits.add("6");
		digits.add("7");
		digits.add("8");
		digits.add("9");
	
		
		makeTexturesFromList(monthes);
		makeTexturesFromList(digits);
		monthes.clear();
		digits.clear();
		
		
	}
	
	public void makeTexturesFromList(List<String> list) {
		int width=0;
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int height = fm.getHeight();
        
		for (String month:list) {
			
	       if (width<fm.stringWidth(month))
	         width = fm.stringWidth(month);
	       
	        
		}
		g2d.dispose();
		for (String month:list) {
			
		       if (width<fm.stringWidth(month))
		         width = fm.stringWidth(month);
		       
		        
			}
			g2d.dispose();
			for (String month:list) {
				

			        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			        g2d = img.createGraphics();
			        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
			        g2d.setFont(font);
			        fm = g2d.getFontMetrics();
			        g2d.setColor(Color.BLACK);
			        g2d.drawString(month, 0, fm.getAscent());
			        g2d.dispose();
			        convertImageData(img);
			        try {
			            ImageIO.write(img, "png", new File(month+".png"));
			        } catch (IOException ex) {
			            ex.printStackTrace();
			        }
			}
		
	}
	public ByteBuffer convertImageData(BufferedImage bi) 
	{
	    byte[] pixelData = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
	    //        return ByteBuffer.wrap(pixelData);
	    ByteBuffer buf = ByteBuffer.allocateDirect(pixelData.length);
	    buf.order(ByteOrder.nativeOrder());
	    buf.put(pixelData);
	    buf.flip();
	    return buf;
	}

}
