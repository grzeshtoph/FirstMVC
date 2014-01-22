package com.springinaction.firstmvc.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.primitives.Longs;
import com.springinaction.firstmvc.model.Phone;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Sole implementatiom of {@link PhoneService}.
 */
public class PhoneServiceImpl implements PhoneService {
    private Map<Long, Phone> phonesMap;

    public void setPhonesMap(Map<Long, Phone> phonesMap) {
        this.phonesMap = phonesMap;
    }

    @Override
    public Set<Phone> getPhones() {
        return ImmutableSortedSet.copyOf(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return Longs.compare(o1.getId(), o2.getId());
            }
        }, phonesMap.values());
    }

    @Override
    public Phone getPhone(long phoneId) {
        return phonesMap.get(phoneId);
    }
}
