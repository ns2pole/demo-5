package com.example.servingwebcontent;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;

public class MyUserDetails implements UserDetails {


	private static final long serialVersionUID = 1L;
	
	private final User user;

	public MyUserDetails(User user) {
		this.user = user;
	}


	@Override
	public String getPassword() {
		return user.getPassword();
	}

	public String getUserId() {
		return user.getUserId();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(user.getAuth());
	}

}