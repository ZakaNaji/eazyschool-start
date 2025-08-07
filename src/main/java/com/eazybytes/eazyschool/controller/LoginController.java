package com.eazybytes.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String displayLoginPage(@RequestParam(name = "error", required = false) String error,
                                   @RequestParam(name = "logout", required = false) String logout,
                                   Model model) {
        String errorMessge = "";
        if (error != null) {
            errorMessge = "Failed to login";
        } else if (logout != null) {
            errorMessge = "You have been logged out";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "login.html";
    }

}