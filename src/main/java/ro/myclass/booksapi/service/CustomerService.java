package ro.myclass.booksapi.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.myclass.booksapi.models.Customer;
import ro.myclass.booksapi.repo.BookRepo;
import ro.myclass.booksapi.repo.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    private BookRepo bookRepo;

    private CustomerRepo customerRepo;

    public CustomerService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> showCustomer(){
        return this.customerRepo.getAllCustomers();
    }

    public List<Customer> showAllBooks(){

    }
}
