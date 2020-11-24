package com.pinback.beltexamdaniel.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pinback.beltexamdaniel.models.LoginUser;
import com.pinback.beltexamdaniel.models.User;
import com.pinback.beltexamdaniel.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User create(User registerUser) {
		String hashed = BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt());
		registerUser.setPassword(hashed);
		return userRepo.save(registerUser);
	}

	public User getUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	public User getUser(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
	    if(result.hasErrors()) {
	        return null;
	    }
	    User existingUser = getUser(loginUser.getEmail());
	    if(existingUser == null) {
	        result.rejectValue("email", "Unique", "Unknow email");
	        return null;
	    }
	    if(!BCrypt.checkpw(loginUser.getPassword(), existingUser.getPassword())) {
	        result.rejectValue("password", "Matches", "Incorrect Password");
	        return null;
	    }
	    return existingUser;
	}

}
