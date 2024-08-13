package com.example.demo_basic_hexagonal.adapter.rest.config;

import com.example.demo_basic_hexagonal.domain.service.BookService;
import com.example.demo_basic_hexagonal.infrastructure.springdata.portimpl.BookPortImpl;
import com.example.demo_basic_hexagonal.infrastructure.springdata.repository.BookEntityRepository;
import com.example.demo_basic_hexagonal.shared.port.BookPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final BookEntityRepository bookEntityRepository;

    @Autowired
    public AppConfig(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Bean
    public BookService bookService() {
        return new BookService(bookPort());
    }

    @Bean
    public BookPort bookPort() {
        return new BookPortImpl(bookEntityRepository);
    }
}
