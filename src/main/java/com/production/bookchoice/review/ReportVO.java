package com.production.bookchoice.review;

import java.sql.Date;

import lombok.Data;

@Data
public class ReportVO {
	
	private int id;
	private int reviewId;
	private int reasonId;
	private Date date;
	private String status;
}
