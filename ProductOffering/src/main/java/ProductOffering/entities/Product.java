package ProductOffering.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prod_id")
	private int prodId;
	
	@Column(name="prod_name")
	private String prodName;
	
	@Column(name="prod_desc")
	private String desc;
	
	@Column(name="price")
	private int price;
	
	@OneToMany(mappedBy = "prod")
	private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int id) {
		this.prodId = id;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + prodId + ", prodName=" + prodName + ", desc=" + desc + ", price=" + price + "]";
	}
	
	

}
