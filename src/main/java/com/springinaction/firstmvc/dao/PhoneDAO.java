package com.springinaction.firstmvc.dao;

import com.springinaction.firstmvc.model.persistence.Phone;

import java.util.List;

/**
 * The DAO interface for phones.
 */
public interface PhoneDAO {
    List<Phone> getPhones();

    List<Phone> getPhones(String name);

    Phone getPhone(String id);

    long createNew(Phone phone);

    long update(Phone phone);
}
