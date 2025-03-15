package com.example.EmployeePay.Interface;

import com.example.EmployeePay.DTO.*;
import org.springframework.stereotype.Service;

@Service
public interface I_AuthInterface {

    public String register(AuthUserDTO user) throws Exception;


    public String login(LoginDTO user);

    public AuthUserDTO forgotPassword(PassDTO pass, String email) throws Exception;

    public String resetPassword(String email, String currentPass, String newPass) throws Exception;
}