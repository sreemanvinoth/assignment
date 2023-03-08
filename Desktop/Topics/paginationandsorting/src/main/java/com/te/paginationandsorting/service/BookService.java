package com.te.paginationandsorting.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.te.paginationandsorting.entity.Book;

public interface BookService {

	List<Book> getBookDetails();
	
	public List<Book> findBooksWithSorting(String field);

	Book saveBookDetails(Book book);
	
	Page<Book> findBookswithPagination(Integer offset,Integer pageSize);

	Page<Book> findBookswithPaginationAndSort(Integer offSet, Integer pageSize, String field);
}
