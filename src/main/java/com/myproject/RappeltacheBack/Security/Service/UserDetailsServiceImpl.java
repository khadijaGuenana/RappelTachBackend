package com.myproject.RappeltacheBack.Security.Service;

import com.myproject.RappeltacheBack.Security.Entity.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private  AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser=accountService.loadUserByUsername(username);
      //  Collection<GrantedAuthority> authorities=new ArrayList<>();

        return new User(appUser.getUsername(),appUser.getPassword(),null);
    }
}
