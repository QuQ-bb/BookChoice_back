package com.production.bookchoice.review;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int id;
	private String creator;
	private String content;
	private BigDecimal grade;
	private Date registrationDate;
	private String isbn;

}
