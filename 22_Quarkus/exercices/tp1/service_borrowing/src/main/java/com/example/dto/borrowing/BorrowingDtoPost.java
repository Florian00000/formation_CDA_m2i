package com.example.dto.borrowing;

import com.example.entity.Borrowing;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class BorrowingDtoPost {

    private String borrowDate;
    private String returnDate;

    private long userId;
    private long bookId;

    public Borrowing toBorrowing() {
        Borrowing borrowing = Borrowing.builder()
                .borrowDate(LocalDate.parse(borrowDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .bookId(bookId)
                .userId(userId)
                .build();
        if (returnDate != null) {
            borrowing.setReturnDate(LocalDate.parse(returnDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        return borrowing;
    }
}
