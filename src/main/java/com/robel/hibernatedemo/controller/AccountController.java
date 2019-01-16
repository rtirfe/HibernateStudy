package com.robel.hibernatedemo.controller;

import com.robel.hibernatedemo.Repository.TransactionRepository;
import com.robel.hibernatedemo.services.AccountService;
import com.robel.hibernatedemo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;
    @RequestMapping("/")
    private String getHome(Model model){
        model.addAttribute("id", 1);
        model.addAttribute("balance", accountService.getBalance(1L));
        model.addAttribute("description", transactionService.getDescription(1L));
        return "index";
    }

    @RequestMapping(value="/deposit")
    private String deposit(Model model){
        return "deposit";
    }

    @RequestMapping(value="/deposit", method=RequestMethod.POST)
    private String depositSubmit(HttpServletRequest request){
        System.out.println(request.getParameter("accountId"));
        System.out.println(request.getParameter("amount"));
        return "redirect:/";
    }

}
