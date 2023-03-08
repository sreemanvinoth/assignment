package com.te.paginationandsorting.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.paginationandsorting.entity.Book;
import com.te.paginationandsorting.repository.BookRepo;
import com.te.paginationandsorting.response.ApiResponse;
import com.te.paginationandsorting.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	public void initDb() {

	}

	@GetMapping("/getBooks")
	public ApiResponse<List<Book>> getBooks() {
		List<Book> findAll = service.getBookDetails();
		if (!findAll.isEmpty())
			return new ApiResponse<>(findAll.size(), findAll);
		else
			return new ApiResponse<>(findAll.size(), findAll);
	}

	@PostMapping("/saveBooks")
	public ResponseEntity<?> saveBooks(@RequestBody Book book) {
		Book save = service.saveBookDetails(book);

		if (save != null) {
			return new ResponseEntity<>(save, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("not saved", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/sort/{field}")
	public ApiResponse<List<Book>> getBooksWithSorting(@PathVariable String field) {
		List<Book> booksWithSorting = service.findBooksWithSorting(field);
		if (!booksWithSorting.isEmpty()) {
			return new ApiResponse<>(booksWithSorting.size(), booksWithSorting);
		} else
			return new ApiResponse<>(booksWithSorting.size(), booksWithSorting);

	}

	@GetMapping("/pagination/{offSet}/{pageSize}")
	public ApiResponse<Page<Book>> getBookswithSorting(@PathVariable Integer offSet, @PathVariable Integer pageSize) {

		Page<Book> pagination = service.findBookswithPagination(offSet, pageSize);
		if (!pagination.isEmpty()) {
			return new ApiResponse<>(pagination.getSize(), pagination);
		} else
			return new ApiResponse<>(pagination.getSize(), pagination);
	}

	@GetMapping("/sortpage/{offSet}/{pageSize}/{field}")
	public ApiResponse<Page<Book>> getBookswithSortingAndPaging(@PathVariable Integer offSet,
			@PathVariable Integer pageSize, @PathVariable String field) {

		Page<Book> sortedPagination = service.findBookswithPaginationAndSort(offSet, pageSize, field);
		if (!sortedPagination.isEmpty()) {
			return new ApiResponse<>(sortedPagination.getSize(), sortedPagination);
		} else
			return new ApiResponse<>(sortedPagination.getSize(), sortedPagination);
	}
}
