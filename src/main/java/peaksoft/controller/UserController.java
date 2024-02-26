package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.entity.User;
import peaksoft.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("profile",userService.userProfile());
        return "/user";
    }

    @GetMapping("/new")
    private String createCompany(Model model){
        model.addAttribute("newUser",new User());
        return "signin";
    }
    @PostMapping("/save")
    private String saveUser(@ModelAttribute("newUser")User user){
        userService.signup(user);
        return"redirect:/user";

    }






}
