package com.store.catalog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A CustomerAccount.
 */
@Entity
@Table(name = "customer_account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "customeraccount")
public class CustomerAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "count_amount")
    private Double countAmount;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "des")
    private String des;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CustomerCoupon> coupons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public CustomerAccount customerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getCountAmount() {
        return countAmount;
    }

    public CustomerAccount countAmount(Double countAmount) {
        this.countAmount = countAmount;
        return this;
    }

    public void setCountAmount(Double countAmount) {
        this.countAmount = countAmount;
    }

    public Integer getCredit() {
        return credit;
    }

    public CustomerAccount credit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getDes() {
        return des;
    }

    public CustomerAccount des(String des) {
        this.des = des;
        return this;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public CustomerAccount createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public CustomerAccount addresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public CustomerAccount addAddress(Address address) {
        this.addresses.add(address);
        address.setAccount(this);
        return this;
    }

    public CustomerAccount removeAddress(Address address) {
        this.addresses.remove(address);
        address.setAccount(null);
        return this;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<CustomerCoupon> getCoupons() {
        return coupons;
    }

    public CustomerAccount coupons(Set<CustomerCoupon> customerCoupons) {
        this.coupons = customerCoupons;
        return this;
    }

    public CustomerAccount addCoupon(CustomerCoupon customerCoupon) {
        this.coupons.add(customerCoupon);
        customerCoupon.setAccount(this);
        return this;
    }

    public CustomerAccount removeCoupon(CustomerCoupon customerCoupon) {
        this.coupons.remove(customerCoupon);
        customerCoupon.setAccount(null);
        return this;
    }

    public void setCoupons(Set<CustomerCoupon> customerCoupons) {
        this.coupons = customerCoupons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerAccount customerAccount = (CustomerAccount) o;
        if (customerAccount.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, customerAccount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
            "id=" + id +
            ", customerId='" + customerId + "'" +
            ", countAmount='" + countAmount + "'" +
            ", credit='" + credit + "'" +
            ", des='" + des + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
