package ro.myclass.booksapi.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.myclass.booksapi.models.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT customer FROM Customer customer")
    List<Customer> getAllCustomers();


}
