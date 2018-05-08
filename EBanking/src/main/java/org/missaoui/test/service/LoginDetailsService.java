package org.missaoui.test.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.missaoui.test.dao.AbonneUserDAO;
import org.missaoui.test.dao.AdministrateurUserDAO;
import org.missaoui.test.model.Abonne;
import org.missaoui.test.model.Administrateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginDetailsService")
public class LoginDetailsService implements UserDetailsService {

	@Autowired
	private AdministrateurUserDAO userDao;
	
	@Autowired 
	private AbonneUserDAO user2Dao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		Administrateur user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority("admin");
		Abonne user2 = user2Dao.findByUserName(username);
		List<GrantedAuthority> authorities2 = buildUserAuthority("user");
		UserDetails ud=null;
		try
		{
			ud = buildUserForAuthentication(user, authorities);
			return ud;
		}catch(Exception ex) {
			ud=buildUserForAuthentication(user2, authorities2);
			return ud;
		}
	}

	// Converts Administrateur user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Administrateur user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private User buildUserForAuthentication(Abonne user, List<GrantedAuthority> authorities) {
		return new User(user.getCodeAbonne(), user.getPasswordAbonne(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(String usertype) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		if(usertype=="admin")
			setAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		else
			setAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}