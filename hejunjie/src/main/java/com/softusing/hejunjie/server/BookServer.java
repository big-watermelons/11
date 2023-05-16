package com.softusing.hejunjie.server;

import com.softusing.hejunjie.entity.Book;
import com.softusing.hejunjie.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServer {

    @Autowired
    private Bookrepository bookrepository;

    public List<Book> findAll() {
        return bookrepository.findAll();
    }

    /*
    新增一个书单信息
     */
    public Book save(Book book) {
        return bookrepository.save(book);
    }

    /*

     */


    public Book findOne(long id) {
        return bookrepository.findById(id).get();
//        return bookrepository.findOne(id);
    }


    //void 删除 无返回值 所以用void
    public void delete(long id) {
//        bookrepository.deleteById(id);
        bookrepository.deleteById(id);
    }

    public List<Book> findByAuthor(String author) {
        return bookrepository.findByAuthor(author);
    }


    /*
     根据author和status来查询
     */
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookrepository.findByAuthorAndStatus(author, status);
    }

    /*
    根据结尾来查询
     */
    public List<Book> findByDescriptionEndsWith(String des) {
        return bookrepository.findByDescriptionContains(des);
    }


    public List<Book> findByJPQL(int len) {
        return bookrepository.findByJPQL(len);
    }

}
