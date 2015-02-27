package products;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatterBuilder;

public class TimeUtil {
	public String humanPeriod(Period period) {
		PeriodFormatterBuilder fmt;
		 
		if(period.getYears() > 0) {
			 fmt = new PeriodFormatterBuilder().appendYears().appendSuffix(" year", " years");
		} else {
			if(period.getMonths()>0) {
				fmt = new PeriodFormatterBuilder().appendMonths().appendSuffix(" month", " months");			
			} else if (period.getDays() >0) {
				fmt = new PeriodFormatterBuilder().appendDays().appendSuffix(" day", " days");							
			} else if (period.getHours() > 0){
				fmt = new PeriodFormatterBuilder().appendHours().appendSuffix(" hour", " hours");											
			} else if (period.getMinutes() > 0) {
				fmt = new PeriodFormatterBuilder().appendMinutes().appendSuffix(" min");				
			} else if (period.getSeconds() > 0){
				fmt = new PeriodFormatterBuilder().appendSeconds().appendSuffix("s");				
			} else {
				return "instants ago";
			}
		}
		
		return fmt.appendSuffix(" ago").toFormatter().print(period);
	}
	
	public static void main(String args[]) {
		Period p1 = new Period(0, 0, 0, 0,1, 1, 10, 0);
		//System.out.println(humanPeriod(p1));
	}
}
