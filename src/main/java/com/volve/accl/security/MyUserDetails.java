package com.volve.accl.security;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.volve.accl.domain.Users;

public class MyUserDetails implements UserDetails {
	
	private String userName;
	private String password;
	private boolean active;
	private String role;
	private List<GrantedAuthority> authorities;
	
	
	public MyUserDetails() {
		super();
	}


	public MyUserDetails(Users user) {
		super();
		this.userName = user.getUsername();
		this.password = user.getPassword();
		this.active = user.getActive();
		this.role = user.getRole().getName();
		this.authorities = authorities;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

//    private static final long serialVersionUID = 1L;
//
//    private Long id;
//
//    private String username;
//
//    private String email;
//
//    @JsonIgnore
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public MyUserDetails(Long id, String username, String email, String password,
//            Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    public static MyUserDetails build(Users user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
//
//        return new MyUserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        MyUserDetails user = (MyUserDetails) o;
//        return Objects.equals(id, user.id);
//    }
//
//    @Override
//    public String toString() {
//        return "UserDetailsImpl [authorities=" + authorities + ", email=" + email + ", id=" + id + ", password="
//                + password + ", username=" + username + "]";
//    }

}