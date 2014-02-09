package com.springinaction.firstmvc.dao;

import com.springinaction.firstmvc.model.persistence.Phone;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

import com.springinaction.firstmvc.model.persistence.Phone;

/**
 * Hibernate implementation of {@link PhoneDAO}.
 */
@Repository
public class PhoneDAOHibernateImpl implements PhoneDAO {
    private SessionFactory sessionFactory;

    @Inject
    public PhoneDAOHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Phone> getPhones() {
        List<Phone> phones = getCurrentSession().createCriteria(Phone.class).addOrder(Order.asc("id")).list();
        return phones;
    }

    @Override
    public Phone getPhone(String id) {
        Query query = getCurrentSession().createQuery("FROM Phone p WHERE p.id = :id");
        query.setParameter("id", id);
        return (Phone) query.uniqueResult();
    }
}