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
 * A Regions.
 */
@Entity
@Table(name = "regions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "regions")
public class Regions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "is_parent")
    private Boolean isParent;

    @Column(name = "des")
    private String des;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @OneToMany(mappedBy = "regions")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Address> addresses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Regions name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Regions parentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean isIsParent() {
        return isParent;
    }

    public Regions isParent(Boolean isParent) {
        this.isParent = isParent;
        return this;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public String getDes() {
        return des;
    }

    public Regions des(String des) {
        this.des = des;
        return this;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Regions createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Regions addresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Regions addAddress(Address address) {
        this.addresses.add(address);
        address.setRegions(this);
        return this;
    }

    public Regions removeAddress(Address address) {
        this.addresses.remove(address);
        address.setRegions(null);
        return this;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Regions regions = (Regions) o;
        if (regions.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, regions.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Regions{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", parentId='" + parentId + "'" +
            ", isParent='" + isParent + "'" +
            ", des='" + des + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
