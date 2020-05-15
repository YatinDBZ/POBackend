package ProductOffering.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProductOffering.dao.LoginDAO;
import ProductOffering.dto.LoginDTO;
import ProductOffering.dto.UserDTO;
import ProductOffering.entities.User;

@Service
public class LoginService{
	@Autowired
	LoginDAO loginDao;
	
	
	public boolean registerUser(UserDTO userdto)
	{
		return loginDao.createUser(userdto);
	}
	
	public List<User> loginUser(LoginDTO loginObj)
	{
		return loginDao.loginUser(loginObj);
	}
	
}