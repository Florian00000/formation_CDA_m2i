package org.example.config;

import org.example.infrastructure_spring_data.portimpl.BookPortImpl;
import org.example.infrastructure_spring_data.repository.BookEntityRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class RestAppInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;

    public RestAppInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("BookService", new BookService(new BookPortImpl(infraContext.getBean(BookEntityRepository.class))));
    }
}
