package ProductOffering.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ProductOffering.entities.Order;
import ProductOffering.entities.OrderDetails;

@Repository
@Transactional
public class OrderDAO {
	
	@PersistenceContext
	 private EntityManager entityManager;
	
	public List getOrderHistory(Long userId) {
		
		List order = entityManager.createQuery("select pd.prodId, pd.prodName, pd.desc, pd.price, o.orderId, od.quantity from"
				+ " OrderDetails od, Order o, Product pd, User u"
				+ " where u.id = " + userId
				+ " and o.status='delivered' group by o.orderDate,o.orderId,pd.prodId,od.id").getResultList();

		return order;
	}
	
	
	

}
