package org.example.port;



import org.example.dto.BookDTO;

import java.util.List;

public interface BookPort {
    BookDTO save(BookDTO book);
    List<BookDTO> get();
}
