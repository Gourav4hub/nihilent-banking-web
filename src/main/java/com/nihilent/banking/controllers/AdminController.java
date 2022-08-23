package com.nihilent.banking.controllers;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nihilent.banking.entity.BankUser;
import com.nihilent.banking.models.LoginUserInfo;
import com.nihilent.banking.models.LoginUserModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.response.TokenResponse;
import com.nihilent.banking.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AdminController 
{
	@Autowired
	private UserService userService;
	
		
	@PostMapping("/authenticate")
	public ApiResponse authenticate(@RequestBody LoginUserModel loginUser)
	{
		BankUser user = userService.getByName(loginUser.getUsername());
		if(user!=null) {
			if(user.getPassword().equals(loginUser.getPassword())) 
			{
				String type = new ArrayList<>(user.getRoles()).get(0).getRoleName();
				return new ApiResponse(true, new LoginUserInfo(user.getUsername(),type ,null), "Success");
			}
			else {
				return new ApiResponse(false, null, "Invalid Password !");
			}
		}else {
			return new ApiResponse(false, null, "Invalid User Name ! ");
		}
	}
	
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "Access Denied ";
	}
	
	@GetMapping("/expireToken")
	public ResponseEntity<TokenResponse> expireToken()
	{
		TokenResponse response = new TokenResponse(true, true, "Token Expire !");
		return ResponseEntity.badRequest().body(response);
	}
	
	@RequestMapping(value =  "/noToken",method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity<TokenResponse> noToken()
	{
		TokenResponse response = new TokenResponse(false, false, "Token Not Found !");
		return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping("/invalidToken")
	public ResponseEntity<TokenResponse> invalidToken()
	{
		TokenResponse response = new TokenResponse(true, false, "Invalid Token !");
		return ResponseEntity.badRequest().body(response);
	}
}

