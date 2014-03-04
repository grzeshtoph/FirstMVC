package com.springinaction.firstmvc.dao;

import com.springinaction.firstmvc.model.persistence.Phone;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Hibernate implementation of {@link PhoneDAO}.
 */
@Repository
public class PhoneDAOHibernateImpl implements PhoneDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Phone> getPhones() {
        return getCurrentSession().createCriteria(Phone.class).addOrder(Order.asc("id")).list();
    }

    @Override
    public List<Phone> getPhones(String name) {
        return getCurrentSession().createCriteria(Phone.class)
                .add(Restrictions.ilike("name", name, MatchMode.ANYWHERE)).addOrder(Order.asc("id")).list();
    }

    @Override
    public Phone getPhone(String id) {
        Query query = getCurrentSession().createQuery("FROM Phone p WHERE p.id = :id");
        query.setParameter("id", id);
        return (Phone) query.uniqueResult();
    }

    @Override
    public long createNew(Phone phone) {
        return (Long) getCurrentSession().save(phone);
    }

    @Override
    public long update(Phone phone) {
        Phone existingPhone = getPhone(phone.getId());
        phone.setPk(existingPhone.getPk());
        return ((Phone)getCurrentSession().merge(phone)).getPk();
    }
}
