package org.example.service;

import org.example.entitie.User;
import org.example.repository.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends BaseService implements Repository<User> {

    public UserService() {
        super();
    }

    @Override
    public boolean create(User o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(User o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public User findById(int id) {
        session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> users = query.list();
        session.close();
        return users;
    }


    public void close(){
        sessionFactory.close();
    }
}
