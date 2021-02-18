package psn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Order_Detail")
public class OrderDetail {
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Price")
	private float price;
	@Column(name = "Amount")
	private float amount;
	//User
	@ManyToOne
	@JoinColumn(name = "Order_Id", referencedColumnName = "Order_Id")
	private Orders orders;
	// ProductDetails
	@Id
	@Column(name = "Products_Details_Id")
	private String productDetailsId;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int quantity, float price, float amount, Orders orders, String productDetailsId) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
		this.orders = orders;
		this.productDetailsId = productDetailsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(String productDetailsId) {
		this.productDetailsId = productDetailsId;
	}
	
	
}
