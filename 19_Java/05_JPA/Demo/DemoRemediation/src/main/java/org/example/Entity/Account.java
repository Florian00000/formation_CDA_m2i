package org.example.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue
    private int idAccount;

    @NotNull
    private String libelle;

    @NotNull
    @Column(length = 27)
    private String iban;

    private float balance;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "account_customer",joinColumns = @JoinColumn(name = "idAccount"),
    inverseJoinColumns = @JoinColumn(name = "idCustomer"))
    private List<Customer> customers;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name  = "idAgency")
    private Agency agency;

    public void add (Customer customer){
        customers.add(customer);
    }
}
