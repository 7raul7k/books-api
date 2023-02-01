package ro.myclass.booksapi.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Table(name = "customer")
@Entity(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "fullName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String fullName;


    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String email;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INT"
    )
    private int age;

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.EAGER)
    @JsonManagedReference
   private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        this.loadLazzyColection();
        book.setCustomer(this);
        this.bookList.add(book);
    }
    @Transactional
    public void loadLazzyColection(){
        this.bookList.size();
    }
}
