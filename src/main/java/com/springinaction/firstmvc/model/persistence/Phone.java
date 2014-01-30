package com.springinaction.firstmvc.model.persistence;

import com.google.common.base.Objects;

/**
 * Value object storing data about a phone.
 */
public class Phone {
    private long id;
    private String name;
    private int price;
    private String opinion;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getOpinion() {
        return opinion;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("name", name).add("price", price)
                .add("opinion", opinion).toString();
    }
}
