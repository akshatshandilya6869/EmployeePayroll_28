package com.example.EmployeePay.Controller;

import com.example.EmployeePay.DTO.*;
import com.example.EmployeePay.Interface.I_AuthInterface;
import com.example.EmployeePay.Service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthUserController {
    ObjectMapper obj = new ObjectMapper();

    @Autowired
    EmailService emailService;

    @Autowired
    I_AuthInterface iAuthInterface;


    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user) throws Exception{
        log.info("Employee tried to register with body: {}", obj.writeValueAsString(user));
        return iAuthInterface.register(user);
    }
    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user) throws Exception{
        log.info("Employee tried to login with body: {}", obj.writeValueAsString(user));
        return iAuthInterface.login(user);
    }


    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message) throws Exception{
        log.info("Employee tried to send email with body: {}", obj.writeValueAsString(message));
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";
    }


    @PutMapping("/forgotPassword/{email}")
    public AuthUserDTO forgotPassword(@RequestBody PassDTO pass, @PathVariable String email) throws Exception{
        log.info("Employee applied for forgot password with body: {}", obj.writeValueAsString(pass));
        return iAuthInterface.forgotPassword(pass, email);
    }


    @PutMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email ,@RequestParam String currentPass, @RequestParam String newPass) throws Exception{
        log.info("Employee applied for forgot password with email: {}", email);
        return iAuthInterface.resetPassword(email, currentPass, newPass);
    }

}