package com.enterprise.netmovies;

import com.enterprise.netmovies.models.Authority;
import com.enterprise.netmovies.repository.UserDetailsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;


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
//		List<Authority> authorityList = new ArrayList<>();
//		authorityList.add(createAuthority("USER","User role"));
////		authorityList.add(createAuthority("ADMIN","Admin role"));
//		User user = new User();
//		user.setUserName("kapedani23");
//		user.setFirstName("Kapo");
//		user.setLastName("Doe");
//		user.setPassword(passwordEncoder.encode("test@1223"));
//		user.setWatchListMovies("803114");
//		user.setWatchListSeries("1402");
//		user.setEnabled(true);
//		user.setAuthorities(authorityList);
//		userDetailsRepository.save(user);
	}

	private Authority createAuthority(String roleCode,String roleDescription){
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
