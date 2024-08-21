package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.ClientDto;
import org.example.dto.ProductDto;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantity;
    private LocalDateTime orderDate;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "client_id")
    private Long clientId;

    @Transient
    private ClientDto client;

    @Transient
    private ProductDto product;
}
