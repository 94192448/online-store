package com.store.catalog.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A CustomerCoupon.
 */
@Entity
@Table(name = "customer_coupon")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "customercoupon")
public class CustomerCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    private CustomerAccount account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public CustomerCoupon couponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Double getAmount() {
        return amount;
    }

    public CustomerCoupon amount(Double amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public CustomerCoupon startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public CustomerCoupon endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public CustomerCoupon createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public CustomerCoupon account(CustomerAccount customerAccount) {
        this.account = customerAccount;
        return this;
    }

    public void setAccount(CustomerAccount customerAccount) {
        this.account = customerAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerCoupon customerCoupon = (CustomerCoupon) o;
        if (customerCoupon.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, customerCoupon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CustomerCoupon{" +
            "id=" + id +
            ", couponId='" + couponId + "'" +
            ", amount='" + amount + "'" +
            ", startDate='" + startDate + "'" +
            ", endDate='" + endDate + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
