package org.example.exercice6.repository;

import org.example.exercice6.models.User;
import org.hibernate.Session;

import java.util.List;

public class UserRepository extends Repository<User>{

    public UserRepository(Session session) {
        super(session);
    }

    @Override
    User findById(int id) {
        return (User) _session.get(User.class, id);
    }

    public User findByEmailAndPassword(String email, String password) {
        return  _session.createQuery("from User where mail = :email and password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    List<User> findAll() {
        return _session.createQuery("from User", User.class).list();
    }
}
