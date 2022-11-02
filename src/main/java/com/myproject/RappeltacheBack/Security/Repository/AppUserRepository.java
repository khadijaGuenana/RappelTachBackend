package com.myproject.RappeltacheBack.Security.Repository;

import com.myproject.RappeltacheBack.Security.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
