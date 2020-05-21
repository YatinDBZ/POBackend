package ProductOffering.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Column(name="prod_id")
	private int prodId;
	
	@Column(name="prod_name")
	private String prodName;
	
	@Column(name="prod_desc")
	private String desc;
	
	@Column(name="price")
	private int price;
	
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
