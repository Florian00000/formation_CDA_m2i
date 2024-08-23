package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.dto.book.BookDtoGet;
import com.example.dto.borrowing.BorrowingDtoPost;
import com.example.dto.user.UserDtoGet;
import com.example.entity.Borrowing;
import com.example.repository.BorrowingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class BorrowingService {

    @Inject
    BorrowingRepository borrowingRepository;

    @Inject
    @RestClient
    BookServiceClient bookServiceClient;

    @Inject
    @RestClient
    UserServiceClient userServiceClient;

    @Transactional
    public Borrowing addBorrowing(BorrowingDtoPost borrowingDtoPost) {
        Borrowing borrowing = borrowingDtoPost.toBorrowing();
        borrowingRepository.persist(borrowing);
        enrichBorrowing(borrowing);
        return borrowing;
    }

    private Borrowing enrichBorrowing(Borrowing borrowing) {
        if (borrowing.getUserId() != null){
            UserDtoGet user = userServiceClient.getUser(borrowing.getUserId());
            if (user == null) throw new WebApplicationException("User not found" + borrowing.getUserId(), 404);
            borrowing.setUser(user);
        }
        if (borrowing.getBookId() != null){
            BookDtoGet book = bookServiceClient.getBook(borrowing.getBookId());
            if (book == null) throw new WebApplicationException("Book not found" + borrowing.getBookId(), 404);
            borrowing.setBook(book);
        }
        return borrowing;
    }
}
