package com.springinaction.firstmvc.service;

import com.google.common.collect.ImmutableList;
import com.springinaction.firstmvc.model.Phone;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Sole implementatiom of {@link PhoneListService}.
 */
public class PhoneListServiceImpl implements PhoneListService {
    @Override
    public List<Phone> getPhones() {
        return ImmutableList.of(
                new Phone(111, "Motorola ABC"),
                new Phone(236, "MOTOROLA 543"),
                new Phone(789, "Dell XYZ"),
                new Phone(234, "Samsung S3")
        );
    }
}
