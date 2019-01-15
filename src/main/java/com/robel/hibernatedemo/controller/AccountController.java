package com.robel.hibernatedemo.controller;

import com.robel.hibernatedemo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;
    @RequestMapping("/")
    private String getHome(Model model){
        System.out.println(accountService.getBalance(10L));
        model.addAttribute("id", 10);
        model.addAttribute("value", accountService.getBalance(10L));

        return "index";
    }

}
