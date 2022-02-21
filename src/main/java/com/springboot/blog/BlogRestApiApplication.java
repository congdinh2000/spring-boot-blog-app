package com.springboot.blog;

import com.springboot.blog.entity.Role;
import com.springboot.blog.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogRestApiApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {

		SpringApplication.run(BlogRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role admin = new Role();
		admin.setName("ROLE_ADMIN");
		roleRepository.save(admin);

		Role user = new Role();
		user.setName("ROLE_USER");
		roleRepository.save(user);

	}
}
