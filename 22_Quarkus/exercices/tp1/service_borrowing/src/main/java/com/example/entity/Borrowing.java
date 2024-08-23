package com.example.entity;

import com.example.dto.book.BookDtoGet;
import com.example.dto.user.UserDtoGet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    @Column(name = "user_id")
    @JsonIgnore
    private Long userId;

    @Column(name = "book_id")
    @JsonIgnore
    private Long bookId;

    @Transient
    private UserDtoGet user;

    @Transient
    private BookDtoGet book;
}
