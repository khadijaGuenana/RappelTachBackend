package com.myproject.RappeltacheBack;

import com.myproject.RappeltacheBack.Entity.Category;
import com.myproject.RappeltacheBack.Entity.SousTache;
import com.myproject.RappeltacheBack.Entity.Tache;
import com.myproject.RappeltacheBack.Security.Entity.AppUser;
import com.myproject.RappeltacheBack.Security.Service.AccountService;
import com.myproject.RappeltacheBack.Security.Service.AccountServiceImpl;
import com.myproject.RappeltacheBack.Service.CategoryServiceImpl;
import com.myproject.RappeltacheBack.Service.SousTacheServiceImpl;
import com.myproject.RappeltacheBack.Service.TacheService;
import com.myproject.RappeltacheBack.Service.TacheServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)

public class RappeltacheBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(RappeltacheBackApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	 CommandLineRunner start(AccountService accountService, TacheServiceImpl tacheService , CategoryServiceImpl categoryService , SousTacheServiceImpl sousTacheService){
		return args -> {

		};
	 }
}
