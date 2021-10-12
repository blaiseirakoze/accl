package com.volve.accl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.volve.accl.domain.AttorneyCategory;
import com.volve.accl.domain.Role;
import com.volve.accl.domain.Users;
import com.volve.accl.exception.HandlerConflictException;
import com.volve.accl.exception.HandlerInternalServerErrorException;
import com.volve.accl.exception.HandlerNotFoundException;
import com.volve.accl.pojo.GlobalResponse;
import com.volve.accl.repository.AttorneyCategoryInterface;
import com.volve.accl.repository.RoleInterface;
import com.volve.accl.repository.UsersInterface;

import java.util.List;

@Service
public class UsersService {

	@Autowired
	private UsersInterface usersInterface;

	@Autowired
	private RoleInterface roleInterface;

	@Autowired
	private AttorneyCategoryInterface attorneyCategoryInterface;

	@Autowired
	PasswordEncoder encoder;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Users signup(Users user) throws Exception {
		Role foundRole = roleInterface.findByName(user.getUserRole());
		Users foundUser = usersInterface.findByUsername(user.getUsername());
		if (foundUser != null) {
			throw new HandlerConflictException("User already exists");
		}
		if (foundRole == null) {
			throw new HandlerNotFoundException("Role not Found");
		}
		if (foundRole.getName().equals("attorney")) {
			AttorneyCategory foundAttorneyCategory = attorneyCategoryInterface
					.findByName(user.getUserAttorneyCategory());
			if (foundAttorneyCategory == null) {
				throw new HandlerNotFoundException("Attorney category not Found");
			}
			user.setAttorneyCategory(foundAttorneyCategory);
			user.setActive(false);
		}

//		save user
		user.setRole(foundRole);
		user.setPassword(encoder.encode(user.getPassword()));

		return usersInterface.save(user);
	}

	/**
	 * 
	 * @return
	 */
	public List<Users> listUsers() {
		try {
			return usersInterface.findAll();
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Users approveAttorney(String id) {
		try {
			Users foundUser = usersInterface.findById(id).orElse(new Users());
			if (foundUser.getUsername().equals(null)) {
				throw new HandlerNotFoundException("User not found");
			}
			foundUser.setActive(true);
			usersInterface.save(foundUser);
			return foundUser;
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public GlobalResponse rateAttorney(String id) {
		try {

			Users foundUser = usersInterface.findById(id).orElse(new Users());

			if (foundUser.getUsername().equals(null)) {
				throw new HandlerNotFoundException("User not found");
			}
			int rate = foundUser.getRate() + 1;
			foundUser.setRate(rate);
			Users ratedUser = usersInterface.save(foundUser);
			return new GlobalResponse(HttpStatus.CREATED.toString(), "Rate added", ratedUser);
		} catch (Exception e) {
			throw new HandlerInternalServerErrorException("Server error");
		}
	}

}
