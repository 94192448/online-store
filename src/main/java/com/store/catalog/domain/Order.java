package com.store.catalog.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * =========shopping-cart-service===========
 */
@ApiModel(description = "=========shopping-cart-service===========")
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "order_amount")
    private Double orderAmount;

    @Column(name = "discount_amount")
    private Double discountAmount;

    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    @Column(name = "freight_amount")
    private Double freightAmount;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    @Column(name = "total_amount")
    private Double totalAmount;

    /**
     * 总费用
     */
    @ApiModelProperty(value = "总费用")
    @Column(name = "address_id")
    private Integer addressId;
    
    @Column(name ="address_des")
    private String addressDes;
    
    @Column(name ="delivery_mobile")
    private String deliveryMobile;
    
    @Column(name ="delivery_name")
    private String deliveryName;

    @Size(max = 600)
    @Column(name = "memo", length = 600)
    private String memo;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "last_modified")
    private ZonedDateTime lastModified;

    @ManyToOne
    private Param orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public Order accountId(Integer accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public Order orderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public Order discountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getFreightAmount() {
        return freightAmount;
    }

    public Order freightAmount(Double freightAmount) {
        this.freightAmount = freightAmount;
        return this;
    }

    public void setFreightAmount(Double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Order totalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public Order addressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getMemo() {
        return memo;
    }

    public Order memo(String memo) {
        this.memo = memo;
        return this;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Order createdAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getLastModified() {
        return lastModified;
    }

    public Order lastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public void setLastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Param getOrderStatus() {
        return orderStatus;
    }

    public Order orderStatus(Param param) {
        this.orderStatus = param;
        return this;
    }

    public void setOrderStatus(Param param) {
        this.orderStatus = param;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        if (order.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", accountId='" + accountId + "'" +
            ", orderAmount='" + orderAmount + "'" +
            ", discountAmount='" + discountAmount + "'" +
            ", freightAmount='" + freightAmount + "'" +
            ", totalAmount='" + totalAmount + "'" +
            ", addressId='" + addressId + "'" +
            ", memo='" + memo + "'" +
            ", createdAt='" + createdAt + "'" +
            ", lastModified='" + lastModified + "'" +
            '}';
    }

	public String getAddressDes() {
		return addressDes;
	}

	public void setAddressDes(String addressDes) {
		this.addressDes = addressDes;
	}

	public String getDeliveryMobile() {
		return deliveryMobile;
	}

	public void setDeliveryMobile(String deliveryMobile) {
		this.deliveryMobile = deliveryMobile;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
}
