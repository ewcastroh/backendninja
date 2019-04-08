package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service("userService")
public class UserService implements UserDetailsService {

	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	/**
	 * Load user by username.
	 *
	 * @param username the username
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.udemy.backendninja.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	/**
	 * Builds the user.
	 *
	 * @param user the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
						true, true, true, authorities);
	}
	
	/**
	 * Builds the authorities.
	 *
	 * @param userRole the user role
	 * @return the list
	 */
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		userRole.stream()
				.map(uRole -> auths.add(new SimpleGrantedAuthority(uRole.getRole())))
				.collect(Collectors.toSet());
		return new ArrayList<GrantedAuthority>(auths);
	}

}
