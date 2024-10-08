package by.salary.useragreementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer moderator;

    private String moderatorComment;
    private Double price;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

}
