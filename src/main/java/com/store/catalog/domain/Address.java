package com.store.catalog.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Address.
 */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "realname")
    private String realname;

    @Column(name = "des")
    private String des;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    private Regions regions;

    @ManyToOne
    private CustomerAccount account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getMobile() {
        return mobile;
    }

    public Address mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealname() {
        return realname;
    }

    public Address realname(String realname) {
        this.realname = realname;
        return this;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDes() {
        return des;
    }

    public Address des(String des) {
        this.des = des;
        return this;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Address createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Regions getRegions() {
        return regions;
    }

    public Address regions(Regions regions) {
        this.regions = regions;
        return this;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public CustomerAccount getAccount() {
        return account;
    }

    public Address account(CustomerAccount customerAccount) {
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
        Address address = (Address) o;
        if (address.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + id +
            ", street='" + street + "'" +
            ", mobile='" + mobile + "'" +
            ", realname='" + realname + "'" +
            ", des='" + des + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
