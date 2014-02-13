package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.dao.PhoneDAO;
import com.springinaction.firstmvc.model.persistence.Phone;

import java.util.List;

/**
 * Sole implementation of {@link PhoneService}.
 */
public class PhoneServiceImpl implements PhoneService {
    private PhoneDAO phoneDAO;

    public void setPhoneDAO(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public List<Phone> getPhones() {
        return phoneDAO.getPhones();
    }

    @Override
    public List<Phone> getPhones(String name) {
        return phoneDAO.getPhones(name);
    }

    @Override
    public Phone getPhone(String phoneId) {
        return phoneDAO.getPhone(phoneId);
    }
}
