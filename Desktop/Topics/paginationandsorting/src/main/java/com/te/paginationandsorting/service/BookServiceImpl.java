package com.te.paginationandsorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.te.paginationandsorting.entity.Book;
import com.te.paginationandsorting.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Override
	public List<Book> getBookDetails() {

		return bookRepo.findAll();
	}

	@Override
	public List<Book> findBooksWithSorting(String field) {
		return bookRepo.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Book saveBookDetails(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Page<Book> findBookswithPagination(Integer offset, Integer pageSize) {
		Page<Book> booksPageWise = bookRepo.findAll(PageRequest.of(offset, pageSize));
		return booksPageWise;
	}

	@Override
	public Page<Book> findBookswithPaginationAndSort(Integer offSet, Integer pageSize, String field) {
		Page<Book> pageAndSort = bookRepo.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(field)));
		return pageAndSort;
	}

}
