package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.model.Phone;

import java.util.List;

/**
 * The interface to operate on list of phones.
 */
public interface PhoneListService {
    List<Phone> getPhones();
}
