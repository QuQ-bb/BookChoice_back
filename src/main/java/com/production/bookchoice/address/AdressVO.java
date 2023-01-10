package com.production.bookchoice.address;

import lombok.Data;

@Data
public class AdressVO {
	
	private int id;
	private String userId;
	private int zipCode;
	private String adres;
	private String adresDetail;
}
