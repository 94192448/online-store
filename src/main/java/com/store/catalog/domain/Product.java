package com.store.catalog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.log.Log;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 1024)
    @Column(name = "description", length = 1024)
    private String description;

    @NotNull
    @Column(name = "whole_price", nullable = false)
    private Double wholePrice;

    @NotNull
    @Column(name = "whole_num", nullable = false)
    private Integer wholeNum;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "in_stock")
    private Boolean inStock;

    /**
     * 下架
     */
    @ApiModelProperty(value = "下架")
    @Column(name = "in_split")
    private Boolean inSplit;

    /**
     * 拆零
     */
    @ApiModelProperty(value = "拆零")
    @Column(name = "ordernum")
    private Integer ordernum;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "last_modified")
    private ZonedDateTime lastModified;
    
    @Column(name = "ico")
    private String ico;

    @ManyToOne
    private Param unit;

    /**
     * 计量规格
     */
    @ApiModelProperty(value = "计量规格")
    @ManyToOne
    private Catalog catalog;

    @ManyToOne
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<LineItem> lineItems = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Product code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWholePrice() {
        return wholePrice;
    }

    public Product wholePrice(Double wholePrice) {
        this.wholePrice = wholePrice;
        return this;
    }

    public void setWholePrice(Double wholePrice) {
        this.wholePrice = wholePrice;
    }

    public Integer getWholeNum() {
        return wholeNum;
    }

    public Product wholeNum(Integer wholeNum) {
        this.wholeNum = wholeNum;
        return this;
    }

    public void setWholeNum(Integer wholeNum) {
        this.wholeNum = wholeNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Product unitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean isInStock() {
        return inStock;
    }

    public Product inStock(Boolean inStock) {
        this.inStock = inStock;
        return this;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean isInSplit() {
        return inSplit;
    }

    public Product inSplit(Boolean inSplit) {
        this.inSplit = inSplit;
        return this;
    }

    public void setInSplit(Boolean inSplit) {
        this.inSplit = inSplit;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public Product ordernum(Integer ordernum) {
        this.ordernum = ordernum;
        return this;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public Product merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Product createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getLastModified() {
        return lastModified;
    }

    public Product lastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public void setLastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Param getUnit() {
        return unit;
    }

    public Product unit(Param param) {
        this.unit = param;
        return this;
    }

    public void setUnit(Param param) {
        this.unit = param;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Product catalog(Catalog catalog) {
        this.catalog = catalog;
        return this;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Brand getBrand() {
        return brand;
    }

    public Product brand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public Product lineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public Product addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
        lineItem.setProduct(this);
        return this;
    }

    public Product removeLineItem(LineItem lineItem) {
        this.lineItems.remove(lineItem);
        lineItem.setProduct(null);
        return this;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Set<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public Product shoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
        return this;
    }

    public Product addShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCarts.add(shoppingCart);
        shoppingCart.setProduct(this);
        return this;
    }

    public Product removeShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCarts.remove(shoppingCart);
        shoppingCart.setProduct(null);
        return this;
    }

    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        if (product.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", code='" + code + "'" +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", wholePrice='" + wholePrice + "'" +
            ", wholeNum='" + wholeNum + "'" +
            ", unitPrice='" + unitPrice + "'" +
            ", inStock='" + inStock + "'" +
            ", inSplit='" + inSplit + "'" +
            ", ordernum='" + ordernum + "'" +
            ", merchantId='" + merchantId + "'" +
            ", createdAt='" + createdAt + "'" +
            ", lastModified='" + lastModified + "'" +
            '}';
    }

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}
    
    
}
