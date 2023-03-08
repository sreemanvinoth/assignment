package com.te.paginationandsorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.paginationandsorting.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
