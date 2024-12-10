package com.feelsync.controller;

import com.feelsync.dto.LoginRequest;
import com.feelsync.dto.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String showLandingPage() {
        return "redirect:/auth";
    }

    @GetMapping("/auth")
    public String showAuthPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        model.addAttribute("signupRequest", new SignupRequest());
        return "auth";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginRequest") LoginRequest loginRequest, 
                        BindingResult bindingResult, 
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("signupRequest", new SignupRequest());
            return "auth";
        }
        
        // TODO: Implement actual authentication logic
        return "redirect:/welcome";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("signupRequest") SignupRequest signupRequest, 
                         BindingResult bindingResult, 
                         Model model) {
        // Validate password match
        if (!signupRequest.getPassword().equals(signupRequest.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.signupRequest", "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("loginRequest", new LoginRequest());
            return "auth";
        }
        
        // TODO: Implement user registration logic
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
