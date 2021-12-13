package com.example.tp5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired private UserRepository userRepository;
    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @PostMapping("/")
    public String
    saveUser(@RequestParam String name, @RequestParam String password,
             @RequestParam String email, @RequestParam String country,
             @RequestParam String state) {
        User u = new User(name, password, email, country, state);
        userRepository.save(u);
        return "redirect:/users";
    }
    @GetMapping("/add")
    public String addUser() {
        return "add";
    }
}
