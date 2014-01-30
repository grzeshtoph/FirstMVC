package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.model.persistence.Phone;

import java.util.Set;

/**
 * The interface to operate on list of phones.
 */
public interface PhoneService {
    Set<Phone> getPhones();

    Phone getPhone(long phoneId);
}
