package dec21st;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {
		
		Date d=new Date();
		
		System.out.println(d);
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String date=simpleDateFormat.format(d);
		
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);

	}

}
