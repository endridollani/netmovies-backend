package com.enterprise.netmovies;

import com.enterprise.netmovies.models.Authority;
import com.enterprise.netmovies.models.User;
import com.enterprise.netmovies.repository.UserDetailsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Data
@SpringBootApplication
public class NetmoviesApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(NetmoviesApplication.class, args);
	}

	@PostConstruct
	protected void init(){
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("USER","User role"));
//		authorityList.add(createAuthority("ADMIN","Admin role"));
		User user = new User();
		user.setUserName("john007");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setPassword(passwordEncoder.encode("test@123"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		userDetailsRepository.save(user);
	}

	private Authority createAuthority(String roleCode,String roleDescription){
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
