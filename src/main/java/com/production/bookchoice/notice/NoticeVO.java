package com.production.bookchoice.notice;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	private int id;
	private String creator;
	private String title;
	private String content;
	private Date registrationDate;
	private Date updateDate;
}
