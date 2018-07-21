package com.store.catalog.domain;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * =========catalog-service===========
 */
@ApiModel(description = "=========catalog-service===========")
@Entity
@Table(name = "shopping_cart")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "shoppingcart")
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "in_split")
    private Boolean inSplit;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    private Product product;
    
    @Column(name = "amount")
    private Double amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public ShoppingCart accountId(Integer accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getPrice() {
        return price;
    }

    public ShoppingCart price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ShoppingCart quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean isInSplit() {
        return inSplit;
    }

    public ShoppingCart inSplit(Boolean inSplit) {
        this.inSplit = inSplit;
        return this;
    }

    public void setInSplit(Boolean inSplit) {
        this.inSplit = inSplit;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ShoppingCart createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public ShoppingCart product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    

    public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingCart shoppingCart = (ShoppingCart) o;
        if (shoppingCart.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, shoppingCart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
            "id=" + id +
            ", accountId='" + accountId + "'" +
            ", price='" + price + "'" +
            ", quantity='" + quantity + "'" +
            ", inSplit='" + inSplit + "'" +
            ", createdAt='" + createdAt + "'" +
            '}';
    }
}
