package org.example.service;

import org.example.entities.Image;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ImageService extends BaseService implements Repository<Image> {

    public ImageService() {
        super();
    }

    @Override
    public boolean create(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Image findById(int id) {
        session = sessionFactory.openSession();
        Image image = session.get(Image.class, id);
        session.close();
        return image;
    }

    @Override
    public List<Image> findAll() {
        session = sessionFactory.openSession();
        Query<Image> query = session.createQuery("from Image", Image.class);
        List<Image> images = query.list();
        session.close();
        return images;
    }

    public void close(){
        sessionFactory.close();
    }
}
