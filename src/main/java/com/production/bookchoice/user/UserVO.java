package com.production.bookchoice.user;

import java.sql.Date;

import lombok.Data;

@Data
public class UserVO {
	
	private String id;
	private String password;
	private String name;
	private Date joinDate;
	private String email;
	private String phone;
	private String withdrawalStts;
	private String reasonWithdrawal;
}
