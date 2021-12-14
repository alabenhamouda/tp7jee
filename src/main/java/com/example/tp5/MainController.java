package com.example.tp5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    saveUser(@RequestParam String login, @RequestParam String password,
             @RequestParam String email, @RequestParam String country,
             @RequestParam String state) {
        User u = new User(login, password, email, country, state);
        userRepository.save(u);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String addUser() {
        return "add";
    }
    @GetMapping("/{id}")
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "edit";
    }
    @PostMapping("/{id}")
    public String
    updateUser(@PathVariable Integer id, @RequestParam String login,
               @RequestParam String password, @RequestParam String email,
               @RequestParam String country, @RequestParam String state) {
        User u = userRepository.findById(id).get();
        u.setLogin(login);
        u.setPassword(password);
        u.setEmail(email);
        u.setCountry(country);
        u.setState(state);
        userRepository.save(u);
        return "redirect:/";
    }
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
