package ro.myclass.booksapi.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.SEQUENCE;

@Table(name = "book")
@Entity(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator  = "books_sequence"
    )
    @Column(
            name ="id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty

    public String name;

    @Column(
            name = "author",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty

    public String author;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @NotEmpty
    private String description;

    @Column(name = "year",
    nullable = false,
    columnDefinition = "INT")
    private int year;

@ManyToOne
@JoinColumn(name = "customer_id",
referencedColumnName = "id",
foreignKey = @ForeignKey(name = "customer_id_fk")
)
@JsonBackReference
private Customer customer;

    public Book(String name, String author, String description, int year, Customer customer) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
        this.customer = customer;
    }
}
