package org.example.tp_jee.services;

import org.example.tp_jee.models.User;
import org.example.tp_jee.repository.UserRepository;
import org.example.tp_jee.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserService {

    private UserRepository userRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public UserService() {
        this.sessionFactory = HibernateSession.getSessionFactory();
    }

    public boolean createUser(String mail, String name, String password){
        boolean result = false;
        session = sessionFactory.openSession();
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

    public boolean loginUser(String mail, String password){
        boolean result = false;
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            result =  userRepository.findByEmailAndPassword(mail, password) != null;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());;
        }finally {
            session.close();
        }
        return result;
    }
}
