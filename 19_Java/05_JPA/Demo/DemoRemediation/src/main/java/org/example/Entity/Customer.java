package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private int idCustomer;
    private String lastname;
    private String firstname;

    @ManyToMany(mappedBy = "customers",fetch = FetchType.EAGER)
    private List<Account> accounts;

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
