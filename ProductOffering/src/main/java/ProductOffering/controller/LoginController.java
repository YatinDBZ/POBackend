package ProductOffering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ProductOffering.dto.LoginDTO;
import ProductOffering.dto.UserDTO;
import ProductOffering.entities.User;
import ProductOffering.response.ProductOfferingResponse;
import ProductOffering.service.LoginService;


@RequestMapping("pclogin")
@Controller
public class LoginController{

	@Autowired
	LoginService loginService;
	
	@PostMapping("register")
	@ResponseBody
	public ProductOfferingResponse createUser(@RequestBody UserDTO userdto) {
		ProductOfferingResponse response = new ProductOfferingResponse();
		if(loginService.registerUser(userdto))
		{
			response.setStatus("success");
			response.setMsg("user created");
		}
		else{
			response.setStatus("fail");
			response.setMsg("request failed");
		}
		return response;
	}

	@PostMapping("login")
	@ResponseBody
	public ProductOfferingResponse authenticateUser(@RequestBody LoginDTO loginObj) {
		List<User> userList =loginService.loginUser(loginObj);
		ProductOfferingResponse response = new ProductOfferingResponse();
		if(userList!=null)
		{
			response.setStatus("success");
			response.setMsg("user verified");
		}
		else{
			response.setStatus("fail");
			response.setMsg("Request Failed!");	
		}
		return response;
	}

}