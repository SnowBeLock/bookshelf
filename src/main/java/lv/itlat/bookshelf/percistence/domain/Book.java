package lv.itlat.bookshelf.percistence.domain;

import jdk.jfr.Name;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "Book")
@Table(name = "BOOK")
public class Book implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Title shouldn't be empty")
    @Column(name="TITLE",length = 100,nullable = false)
    private String title;

    @Column(name ="AUTHOR",length = 100,nullable = false) //Nullable false - ne mozet bit pustiom
    private String author;
    @Min(1)
    @NotNull
    @Column(name ="YEAR",length = 5,nullable = false)
    private int year;

    @Size(min = 10,max = 50)
    @Column(name = "ISBN",nullable = false,unique = true)//unique - UNIKALNIJ -_-.../ NE POVTORITSA
    private String isbn;
    @Size(max = 1000)

    @Column(name="DESCRIPTION")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
