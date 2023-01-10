package com.production.bookchoice.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookList")
	public String aladinList()throws Exception{
		String bl = bookService.bookList();
		
		return bl;
	}

}
