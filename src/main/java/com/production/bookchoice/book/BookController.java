package com.production.bookchoice.book;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookList")
	public JSONObject bookList(String cid)throws Exception{
		JSONObject bl = bookService.bookList(cid);
		
		return bl;
	}
	
	@GetMapping("bookDetail")
	public JSONObject bookDetail(String isbn)throws Exception{
		JSONObject bd = bookService.bookDetail(isbn);
		
		return bd;
	}
	@GetMapping("bookSearch")
	public JSONObject bookSearch(String search)throws Exception{
		JSONObject bs = bookService.bookSearch(search);
		return bs;
	}

}
