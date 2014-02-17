package com.springinaction.firstmvc.model.persistence;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Value object storing data about a phone.
 */
@Entity
@Table(name = "PHONES")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_pk")
    private long pk;
    @Column(name = "phone_id")
    @Pattern(regexp = "\\d{1,10}+", message = "Phone Id must have digits only")
    private String id;
    @Column(name = "name")
    @NotEmpty(message = "Phone name must not be empty")
    private String name;
    @Column(name = "price")
    @NotNull(message = "Phone price must not be empty")
    @DecimalMin(value = "5.00", message = "phone.validation.error.min.price")
    @DecimalMax(value = "9999.99", message = "Maximum price for the phone is 9999.99 euro")
    private BigDecimal price;
    @Column(name = "opinion")
    @NotEmpty(message = "Opinion must no be empty")
    private String opinion;

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("id", id).add("name", name).add("price", price)
                .add("opinion", opinion).toString();
    }
}
