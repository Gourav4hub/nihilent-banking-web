package com.nihilent.banking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.SuperAdmin;
import com.nihilent.banking.entity.User;
import com.nihilent.banking.services.RoleService;
import com.nihilent.banking.services.SuperAdminService;
import com.nihilent.banking.services.UserService;

@SpringBootApplication
public class NihilentBankingWebApplication implements CommandLineRunner 
{
	@Autowired 
	private RoleService roleService;
	@Autowired 
	private UserService userService;
	@Autowired 
	private SuperAdminService superAdminService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(NihilentBankingWebApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		List<SuperAdmin> admins = superAdminService.getByName("Nihilent Admin");
		if(admins.size()==0) 
		{
			Role role = new Role(null, "ROLE_BANK_SUPERADMIN");
			
				Set<Role> sets = new HashSet<>();
				sets.add(role);
		
				User user = new User(null,"super_admin","12345", "nihilent_admin@gmail.com", sets);
				user = userService.save(user);
				if(user!=null) {
					SuperAdmin sadmin = new SuperAdmin(null, "Nihilent Admin", "9879877676", user);
					superAdminService.save(sadmin);
				
			}
		}
	}

	
}
