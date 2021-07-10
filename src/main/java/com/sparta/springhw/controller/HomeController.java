package com.sparta.springhw.controller;

import com.sparta.springhw.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("admin", true);
        return "index";
    }


    @GetMapping("/")
    public String GetSession (HttpServletRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails)  {

        String MyMy = "";
//        String MyMy = userDetails.getUsername();

        try{
            MyMy = userDetails.getUsername();
        }catch (NullPointerException e) {
            MyMy = null;
        }
        request.getSession().setAttribute("MyMy", MyMy);


        return "index";

    }
}
