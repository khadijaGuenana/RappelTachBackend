package com.myproject.RappeltacheBack.Security.Service;

import com.myproject.RappeltacheBack.Security.Entity.AppUser;
import com.myproject.RappeltacheBack.Security.Repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
   private AppUserRepository appUserRepository;
   private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository; //injection par constructeur
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepository.findByUsername(username) ;
    }

    @Override
    public List<AppUser> listUsers() {

        return  appUserRepository.findAll();
    }
}
