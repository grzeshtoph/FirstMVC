package com.springinaction.firstmvc.model;

import com.google.common.base.Objects;

/**
 * Value object storing data about a phone.
 */
public class Phone {
    private long id;
    private String name;

    public Phone(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("name", name).toString();
    }
}
