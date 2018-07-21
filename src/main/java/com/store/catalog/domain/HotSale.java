package com.store.catalog.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A HotSale.
 */
@Entity
@Table(name = "hot_sale")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "hotsale")
public class HotSale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 40)
    @Column(name = "type_id", length = 40)
    private String typeId;

    @Size(max = 40)
    @Column(name = "item_id", length = 40)
    private String itemId;

    @Column(name = "ordernum")
    private Integer ordernum;

    @Size(max = 100)
    @Column(name = "des", length = 100)
    private String des;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public HotSale typeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getItemId() {
        return itemId;
    }

    public HotSale itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public HotSale ordernum(Integer ordernum) {
        this.ordernum = ordernum;
        return this;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getDes() {
        return des;
    }

    public HotSale des(String des) {
        this.des = des;
        return this;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public HotSale createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public HotSale product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HotSale hotSale = (HotSale) o;
        if (hotSale.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, hotSale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "HotSale{" +
            "id=" + id +
            ", typeId='" + typeId + "'" +
            ", itemId='" + itemId + "'" +
            ", ordernum='" + ordernum + "'" +
            ", des='" + des + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
