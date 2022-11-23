package com.yash.security.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.security.common.UserConstant;
import com.yash.security.model.User;
import com.yash.security.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		user.setRole(UserConstant.DEFAULT_ROLE);
		String encrptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encrptedPassword);
		userRepository.save(user);
		return "hi" + user.getUsername() + " welcome";

	}

	// if logged in user is ADMIN -> ADMIN OR MODERATOR
	// if logged in user is MODERATOR -> MODERATOR

	@GetMapping("/access/{userId}/{userRole}")
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
	public String giveAccessToUser(@PathVariable int userId, @PathVariable String userRole, Principal principal) {

		User user = userRepository.findById(userId).get();

		List<String> enabledRole = getRoleByLoggedInUser(principal);

		String newRole = "";
		if (enabledRole.contains(userRole)) {
			newRole = user.getRole() + "," + userRole;

			user.setRole(newRole);

		}
		userRepository.save(user);

		return "Hi" + user.getUsername() + "New Role assign to you by " + principal.getName();

	}

	private List<String> getRoleByLoggedInUser(Principal principal) {

		String role = getLoggedInUser(principal).getRole();

		List<String> assignRole = Arrays.stream(role.split(",")).collect(Collectors.toList());

		if (assignRole.contains("ROLE_ADMIN")) {
			return Arrays.stream(UserConstant.ADMIN_ACCESS).collect(Collectors.toList());
		}
		if (assignRole.contains("ROLE_MANAGER")) {
			return Arrays.stream(UserConstant.MANAGER_ACCESS).collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	private User getLoggedInUser(Principal principal) {
		return userRepository.findByUsername(principal.getName()).get();
	}

	@GetMapping
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> loadUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/test")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String testUserAccess() {

		return "user can access this";
	}
}
