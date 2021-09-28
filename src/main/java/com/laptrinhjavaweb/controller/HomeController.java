package com.laptrinhjavaweb.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.util.WebUtils;


@Controller
public class HomeController {
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
    model.addAttribute("title", "Welcome");
    model.addAttribute("message", "This is welcome page!");
    return "welcomePage";
}

//Đây là trang Admin  
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
	
		principal.getName();
	    User loginedUser = (User) ((Authentication) principal).getPrincipal();
	   // User loginedUser1 = (User)  principal;

	    String userInfo = WebUtils.toString(loginedUser);
	  //  String userInfo1 = WebUtils.toString(loginedUser1);

	    model.addAttribute("userInfo", userInfo);
	  //  model.addAttribute("userInfo1", userInfo1);

	
	    return "adminPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
	
	    return "loginPage";
	}
	
	// khi người dùng logout khỏi hệ thống  
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
	    model.addAttribute("title", "Logout");
	    return "logoutSuccessfulPage";
	}
	
	// khi người dùng đăng nhập thành công
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
	
	    // Sau khi user login thanh cong se co principal
	    String userName = principal.getName();
	
	    System.out.println("User Name: " + userName);
	
	    User loginedUser = (User) ((Authentication) principal).getPrincipal();
	
	    String userInfo = WebUtils.toString(loginedUser);
	    model.addAttribute("userInfo", userInfo);
	
	    return "userInfoPage";
	}
	
	// khi người dùng là user mà thâm nhập trang admin thì mình vào đây
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
	
	    if (principal != null) {
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	
	        String userInfo = WebUtils.toString(loginedUser);
	
	        model.addAttribute("userInfo", userInfo);
	
	        String message = "Hi " + principal.getName() //
	                + "<br> You do not have permission to access this page!";
	        model.addAttribute("message", message);
	
	    }
	
	    return "403Page";
	}

}
