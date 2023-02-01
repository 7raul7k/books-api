package ro.myclass.booksapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.myclass.booksapi.models.Book;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Query("SELECT book from Book book")
    List<Book> getallBooks();
}
