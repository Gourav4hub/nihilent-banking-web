package com.nihilent.banking.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.User;
import com.nihilent.banking.repositories.UserRepository;
@Service
public class UserService implements BaseService<User>
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User ob) {
		try {
			User User = userRepository.save(ob);
			return User;
		}catch(Exception ex) {
			System.out.println("User Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public User update(User ob) {
		try {
			User User = userRepository.save(ob);
			return User;
		}catch(Exception ex) {
			System.out.println("User Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<User> list() {
		try {
			return userRepository.findAll();
		}catch(Exception ex) {
			System.out.println("User List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public User get(int id) {
		try {
			Optional<User> op = userRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("User Save Error : " + ex.getMessage());
			return null;
		}
	}
	
	public User getByName(String name) {
		try {
			Optional<User> op = userRepository.findByUsername(name);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("User getByName Error : " + ex.getMessage());
			return null;
		}
	}

//	private Set<SimpleGrantedAuthority> getAuthority(User user) 
//	{
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//        	authorities.add(new SimpleGrantedAuthority(role.getRoleName().toUpperCase()));
//        });
//        return authorities;
//    }
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> opUser = userRepository.findByUsername(username);
//		if(opUser.isPresent())
//		{
//			User user = opUser.get();
//	        if(user == null){
//	            throw new UsernameNotFoundException("Invalid username or password.");
//	        }else {
//	        	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
//	        }	
//		}else {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//	}

}
