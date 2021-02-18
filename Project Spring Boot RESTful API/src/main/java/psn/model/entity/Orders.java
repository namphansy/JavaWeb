package psn.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@Column(name = "Order_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(name = "Total_Amount")
	private float totalAmount;
	@Column(name = "Order_Status")
	private boolean orderStatus;
	@Column(name = "Created")
	private Date created;
	@Column(name = "Order_Condition")
	private int orderCondition;
	// User
	@ManyToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	private WebUser webUserOrders;
	
	@OneToMany(mappedBy = "orders")
	private List<OrderDetail> listOrderDetails;

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, float totalAmount, boolean orderStatus, Date created, WebUser webUserOrders,
			int orderCondition, List<OrderDetail> listOrderDetails) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.created = created;
		this.webUserOrders = webUserOrders;
		this.orderCondition = orderCondition;
		this.listOrderDetails = listOrderDetails;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getOrderCondition() {
		return orderCondition;
	}

	public void setOrderCondition(int orderCondition) {
		this.orderCondition = orderCondition;
	}

	public WebUser getWebUserOrders() {
		return webUserOrders;
	}

	public void setWebUserOrders(WebUser webUserOrders) {
		this.webUserOrders = webUserOrders;
	}
	
	public List<OrderDetail> getListOrderDetails() {
		return listOrderDetails;
	}

	public void setListOrderDetails(List<OrderDetail> listOrderDetails) {
		this.listOrderDetails = listOrderDetails;
	}

}
