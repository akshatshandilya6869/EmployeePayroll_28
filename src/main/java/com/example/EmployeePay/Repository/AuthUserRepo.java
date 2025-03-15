package com.example.EmployeePay.Repository;

import com.example.EmployeePay.Entities.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthUserRepo extends JpaRepository<AuthUser, Long> {

    public AuthUser findByEmail(String email);

}