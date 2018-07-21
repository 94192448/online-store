package com.store.catalog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Param.
 */
@Entity
@Table(name = "param")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "param")
public class Param implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "ordernum")
    private Integer ordernum;

    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Product> productUnits = new HashSet<>();

    @OneToMany(mappedBy = "orderStatus")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Order> orders = new HashSet<>();

    public Param() {
    }
    public Param(Long id) {
    	this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Param name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Param typeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public Param ordernum(Integer ordernum) {
        this.ordernum = ordernum;
        return this;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Set<Product> getProductUnits() {
        return productUnits;
    }

    public Param productUnits(Set<Product> products) {
        this.productUnits = products;
        return this;
    }

    public Param addProductUnit(Product product) {
        this.productUnits.add(product);
        product.setUnit(this);
        return this;
    }

    public Param removeProductUnit(Product product) {
        this.productUnits.remove(product);
        product.setUnit(null);
        return this;
    }

    public void setProductUnits(Set<Product> products) {
        this.productUnits = products;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Param orders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Param addOrder(Order order) {
        this.orders.add(order);
        order.setOrderStatus(this);
        return this;
    }

    public Param removeOrder(Order order) {
        this.orders.remove(order);
        order.setOrderStatus(null);
        return this;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Param param = (Param) o;
        if (param.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, param.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Param{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", typeId='" + typeId + "'" +
            ", ordernum='" + ordernum + "'" +
            '}';
    }
}
