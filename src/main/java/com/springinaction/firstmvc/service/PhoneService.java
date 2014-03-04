package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.model.persistence.Phone;

import java.util.List;
import java.util.Set;

/**
 * The interface to operate on list of phones.
 */
public interface PhoneService {
    List<Phone> getPhones();

    List<Phone> getPhones(String name);

    Phone getPhone(String phoneId);

    long createNew(Phone phone);

    long updatePhone(Phone phone);
}
