package org.example.exercice6.services;

import org.example.exercice6.models.User;
import org.example.exercice6.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class UserService {

    private UserRepository userRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public UserService(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    public boolean createUser(String mail, String name, String password){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        userRepository = new UserRepository(session);
        User user = new User(mail, name, password);
        try {
            userRepository.create(user);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }

    
}
