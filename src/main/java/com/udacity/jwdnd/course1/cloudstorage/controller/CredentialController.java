package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialController {

    private final UserService userService;
    private final CredentialService credentialService;

    public CredentialController(UserService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    @PostMapping("/add-credential")
    public String addCredentialOrUpdate(Credentials credentials, Authentication authentication, Model model) {
        User user = userService.getUser(authentication.getPrincipal().toString());
        credentials.setUserId(user.getUserId());

        credentialService.addCredentials(credentials);
        model.addAttribute("successMessage", "The credential added Successfully");
        return "result";
    }
}
