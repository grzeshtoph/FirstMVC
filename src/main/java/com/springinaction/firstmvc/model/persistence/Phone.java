package com.springinaction.firstmvc.model.persistence;

import com.google.common.base.Objects;
import com.springinaction.firstmvc.model.validation.BusinessLogicChecks;
import com.springinaction.firstmvc.model.validation.UniquePhoneId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.GroupSequence;
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
@GroupSequence({Phone.class, BusinessLogicChecks.class})
@SequenceGenerator(name = "phoneSequence", sequenceName = "PHONE_PK_SEQ", initialValue = 1, allocationSize = 1)
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneSequence")
    @Column(name = "phone_pk")
    private long pk;
    @Column(name = "phone_id")
    @Pattern(regexp = "\\d{1,10}+", message = "{phone.validation.error.id.pattern}")
    @UniquePhoneId(groups = BusinessLogicChecks.class)
    private String id;
    @Column(name = "name")
    @NotEmpty(message = "{phone.validation.error.name.empty}")
    private String name;
    @Column(name = "price")
    @NotNull(message = "{phone.validation.error.price.empty}")
    @DecimalMin(value = "5.00", message = "{phone.validation.error.price.min}")
    @DecimalMax(value = "9999.99", message = "{phone.validation.error.price.max}")
    private BigDecimal price;
    @Column(name = "opinion")
    @NotEmpty(message = "{phone.validation.error.opinion.empty}")
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
