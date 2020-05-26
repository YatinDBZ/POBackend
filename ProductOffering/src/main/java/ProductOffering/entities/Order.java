package ProductOffering.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Order_Table")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Long orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
	@OneToMany(mappedBy="order")
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
	
	private String status;
	
	// @Temporal(value= TemporalType.DATE)
	@Column(name="order_date")
	private String orderDate;
	
	public Order() {}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getOrder_date() {
		return orderDate;
	}
	public void setOrder_date(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
