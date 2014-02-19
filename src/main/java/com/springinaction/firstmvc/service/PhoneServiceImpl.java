package com.springinaction.firstmvc.service;

import com.springinaction.firstmvc.dao.PhoneDAO;
import com.springinaction.firstmvc.model.persistence.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Sole implementation of {@link PhoneService}.
 */
public class PhoneServiceImpl implements PhoneService {
    private static final Logger LOG = LoggerFactory.getLogger(PhoneServiceImpl.class);
    private PhoneDAO phoneDAO;

    public void setPhoneDAO(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public List<Phone> getPhones() {
        List<Phone> phones = phoneDAO.getPhones();

        LOG.info("Number of all phones found: {}", phones.size());

        return phones;
    }

    @Override
    public List<Phone> getPhones(String name) {
        List<Phone> phones = phoneDAO.getPhones(name);

        LOG.info("Number of phones for name '{}' found: {}", name, phones.size());

        return phones;
    }

    @Override
    public Phone getPhone(String phoneId) {
        final Phone phone = phoneDAO.getPhone(phoneId);

        if (phone == null)
            LOG.info("No phone for id {} found", phoneId);
        else
            LOG.info("Phone for id {} found: {}", phoneId, phone);

        return phone;
    }

    @Override
    public long createNew(Phone phone) {
        final long pk = phoneDAO.createNew(phone);

        LOG.info("New phone created: pk = {}", pk);

        return pk;
    }
}
