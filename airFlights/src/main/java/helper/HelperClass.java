package helper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HelperClass {
	
	public static List<Date> getDatesBetweenUsingJava(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList<>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			     
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);
			 
			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        datesInRange.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
			    return datesInRange;
	}
	
	public static List<Date> getDatesByWeekBetweenUsingJava(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList<>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			     
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);
			    
			    int weekcounter = 0;
			 
			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        
			        if(weekcounter == 7) {
			        	weekcounter = 0;
			        }
			        
			        if(weekcounter == 0) {
			        	datesInRange.add(result);     	
			        }
			        
			        ++weekcounter;
			        calendar.add(Calendar.DATE, 1);
			    }
			    return datesInRange;
	}
	
	public static List<Date> getDatesByMonthBetweenUsingJava(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList<>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			     
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);
			    
			    int weekcounter = 0;
			 
			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        
			        if(weekcounter == 30) {
			        	weekcounter = 0;
			        }
			        
			        if(weekcounter == 0) {
			        	datesInRange.add(result);     	
			        }
			        
			        ++weekcounter;
			        calendar.add(Calendar.DATE, 1);
			    }
			    return datesInRange;
	}

}
