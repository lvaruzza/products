package products

import org.joda.time.DateTime
import org.joda.time.Period


class ProductTagLib {
	static namespace = "prod"
	static TimeUtil timeUtil = new TimeUtil();
	
	def updated = { attrs ->   
		def editedBy=attrs['editedBy']	
		def updated=new DateTime(attrs['updated'])
		DateTime now = new DateTime();
		Period period = new Period(updated, now);
		String periodText = timeUtil.humanPeriod(period);
		
		if (editedBy==null || editedBy=="") {
			out << "${periodText}"
		} else {
			out << "${periodText} by ${editedBy}"
		}
	}
}
