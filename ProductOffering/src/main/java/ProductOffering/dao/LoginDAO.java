package ProductOffering.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ProductOffering.dto.LoginDTO;
import ProductOffering.dto.UserDTO;
import ProductOffering.entities.User;

@Repository
@Transactional
public class LoginDAO
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public boolean createUser(UserDTO userdto) {
		User user = new User(userdto.getFirstName(), 
				userdto.getLastName(), userdto.getMobileNo(), 
				userdto.getPassword(), userdto.getEmail());
		try {
				entityManager.persist(user);
				return Boolean.TRUE;
		
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return Boolean.FALSE;
		}
	}
	
	public List<User> loginUser(LoginDTO loginObj) {
			List<User> user = entityManager.createQuery("FROM User WHERE mobileNo =:mobileNo").
					setParameter("mobileNo", loginObj.getMobileNo()).
					getResultList();
			return user;
	}

}