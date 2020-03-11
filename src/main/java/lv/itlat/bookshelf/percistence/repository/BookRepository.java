package lv.itlat.bookshelf.percistence.repository;

import lv.itlat.bookshelf.percistence.domain.Book;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional

public class BookRepository {

    @PersistenceContext(unitName = "bookshelfPU") //persistence unit must have the same name as is written in persistence.xml
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public Book create(Book book) {
        getEntityManager().persist(book);
        return book;
    }

    public void update(List<Book> books) {
        for (Book book : books) {
            getEntityManager().merge(books);
        }
    }

    public void delete(Book book) {
        if (getEntityManager().contains(book)) {
            getEntityManager().remove(book);
        } else {
            Book managedBook = getEntityManager().find(Book.class, book.getId());
            if (managedBook != null) {
                getEntityManager().remove(managedBook);
            }
        }
    }

    public List<Book> getAll() {
        return getEntityManager().createQuery("SELECT p FROM Book p", Book.class).getResultList();
    }
}
