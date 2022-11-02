package com.myproject.RappeltacheBack.Security.Service;

import com.myproject.RappeltacheBack.Security.Entity.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
