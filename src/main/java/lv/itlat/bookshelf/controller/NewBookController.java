package lv.itlat.bookshelf.controller;


import lv.itlat.bookshelf.percistence.domain.Book;
import lv.itlat.bookshelf.percistence.repository.BookRepository;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class NewBookController implements Serializable {
    private static final Logger logger = Logger.getLogger(NewBookController.class);
    private Book book = new Book();
    @Inject
    private BookRepository bookRepository;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String create() {
        bookRepository.create(book);
        book = new Book();
        return "book-created.xhtml"; //Preduprizdenije s vivodom texta
    }


}
