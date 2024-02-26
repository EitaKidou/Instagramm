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
import peaksoft.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/Registration")
@RequiredArgsConstructor
public class RegistrController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("findUser", userService.userProfile());
        return "/user";
    }

    @GetMapping("/profilePage")
    public String profileee(Model model){
        model.addAttribute("newUser", userService.findUserById(UserServiceImpl.corrent.getId()));
        return "/main";
    }

}
