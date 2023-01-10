package com.production.bookchoice.faq;

import lombok.Data;

@Data
public class FaqVO {
	
	private int id;
	private int cateId;
	private String userId;
	private String title;
	private String content;

}
