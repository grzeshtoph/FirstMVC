package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.model.Phone;

import java.util.List;
import java.util.Set;

/**
 * The interface to operate on list of phones.
 */
public interface PhoneService {
    Set<Phone> getPhones();

    Phone getPhone(long phoneId);
}
