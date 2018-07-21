package com.store.catalog.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModelProperty;

/**
 * A Catalog.
 */
@Entity
@Table(name = "catalog")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "catalog")
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 第一级0
     */
    @ApiModelProperty(value = "第一级0")
    @Column(name = "is_parent")
    private Boolean isParent;

    @Column(name = "ordernum")
    private Integer ordernum;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

   /* @OneToMany(mappedBy = "catalog")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Product> products = new HashSet<>();*/
    
   /* @Transient
    private List<Catalog> childrens;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Catalog name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Catalog description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Catalog parentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean isIsParent() {
        return isParent;
    }

    public Catalog isParent(Boolean isParent) {
        this.isParent = isParent;
        return this;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public Catalog ordernum(Integer ordernum) {
        this.ordernum = ordernum;
        return this;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Catalog createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /*public Set<Product> getProducts() {
        return products;
    }

    public Catalog products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Catalog addProduct(Product product) {
        this.products.add(product);
        product.setCatalog(this);
        return this;
    }

    public Catalog removeProduct(Product product) {
        this.products.remove(product);
        product.setCatalog(null);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog) o;
        if (catalog.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, catalog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Catalog{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", parentId='" + parentId + "'" +
            ", isParent='" + isParent + "'" +
            ", ordernum='" + ordernum + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }

	/*public List<Catalog> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Catalog> childrens) {
		this.childrens = childrens;
	}*/
    
    
}
