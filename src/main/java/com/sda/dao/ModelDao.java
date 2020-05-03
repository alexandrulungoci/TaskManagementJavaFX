package com.sda.dao;


import com.sda.ConfigurationClass;
import com.sda.model.Model;
import com.sda.model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ModelDao<T extends Model> implements DaoInterface {

    private SessionFactory sessionFactory;

    public ModelDao() {
        ConfigurationClass configurationClass = new ConfigurationClass();
        Configuration configuration = configurationClass.getConfiguration();
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void add(Model objectToBeAdded) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(objectToBeAdded);
        transaction.commit();
    }

    @Override
    public void update(Model objectToBeUpdated) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(objectToBeUpdated);
        transaction.commit();
    }

    @Override
    public void remove(Model objectToBeRemoved) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(objectToBeRemoved);
        transaction.commit();
    }

// User methods

    public List<UserModel> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from UserModel", UserModel.class);
        transaction.commit();
        return query.getResultList();
    }

    public UserModel findUserById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserModel userModel = session.find(UserModel.class, id);
        transaction.commit();
        return userModel;
    }

    public Optional<UserModel> findByUserName(String userName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from UserModel where userName = '" + userName + "'", UserModel.class);
        List<UserModel> userModelList = query.getResultList();
        if (userModelList.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(userModelList.get(0));
    }


}
