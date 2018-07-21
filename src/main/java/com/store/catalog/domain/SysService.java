package com.store.catalog.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A SysService.
 */
@Entity
@Table(name = "sys_service")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "sysservice")
public class SysService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    @Column(name = "type", length = 40)
    private String type;

    @Size(max = 20)
    @Column(name = "status", length = 20)
    private String status;

    @Size(max = 40)
    @Column(name = "name", length = 40)
    private String name;

    @Size(max = 40)
    @Column(name = "mobile", length = 40)
    private String mobile;

    @Size(max = 400)
    @Column(name = "address", length = 400)
    private String address;

    @Size(max = 100)
    @Column(name = "product", length = 100)
    private String product;

    @Column(name = "buy_time")
    private LocalDate buyTime;

    @Size(max = 200)
    @Column(name = "seller", length = 200)
    private String seller;

    @Size(max = 200)
    @Column(name = "des", length = 200)
    private String des;

    @Column(name = "create_at")
    private ZonedDateTime createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public SysService type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public SysService status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public SysService name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public SysService mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public SysService address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public SysService product(String product) {
        this.product = product;
        return this;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDate getBuyTime() {
        return buyTime;
    }

    public SysService buyTime(LocalDate buyTime) {
        this.buyTime = buyTime;
        return this;
    }

    public void setBuyTime(LocalDate buyTime) {
        this.buyTime = buyTime;
    }

    public String getSeller() {
        return seller;
    }

    public SysService seller(String seller) {
        this.seller = seller;
        return this;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDes() {
        return des;
    }

    public SysService des(String des) {
        this.des = des;
        return this;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public SysService createAt(ZonedDateTime createAt) {
        this.createAt = createAt;
        return this;
    }

    public void setCreateAt(ZonedDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysService sysService = (SysService) o;
        if (sysService.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, sysService.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SysService{" +
            "id=" + id +
            ", type='" + type + "'" +
            ", status='" + status + "'" +
            ", name='" + name + "'" +
            ", mobile='" + mobile + "'" +
            ", address='" + address + "'" +
            ", product='" + product + "'" +
            ", buyTime='" + buyTime + "'" +
            ", seller='" + seller + "'" +
            ", des='" + des + "'" +
            ", createAt='" + createAt + "'" +
            '}';
    }
}
