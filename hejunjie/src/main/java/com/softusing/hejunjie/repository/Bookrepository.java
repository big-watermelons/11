package com.softusing.hejunjie.repository;

import com.softusing.hejunjie.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bookrepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

    List<Book> findByDescriptionEndsWith(String des);

    List<Book> findByDescriptionContains(String des);


    @Query(value = "select * from book where LENGTH(name)>?1",nativeQuery = true)
//    @Query("select b from Book b where length(b.name) >?1")
    List<Book> findByJPQL(int len);


}
