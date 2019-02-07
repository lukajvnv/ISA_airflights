package com.airFlights.model.avio;

import java.util.Date;

public class AirlineAnalyticsQuery {
	
	public enum ReportType {DEFAULT, DAILY, WEEKLY, MONTHLY };
	
	private Date from;
	private Date to;
	private ReportType reportType;
	
	public AirlineAnalyticsQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(ReportType reportType) {
		this.reportType = reportType;
	}
	

}
