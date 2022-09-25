package pl.milypol.magazinestatus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.milypol.magazinestatus.entity.User;
import pl.milypol.magazinestatus.repository.RoleRepository;
import pl.milypol.magazinestatus.repository.UserRepository;
import pl.milypol.magazinestatus.service.UserServiceInterface;

@Controller
@RequestMapping("/add")
public class AddUserController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserServiceInterface userServiceInterface;

    public AddUserController(UserRepository userRepository, RoleRepository roleRepository, UserServiceInterface userServiceInterface) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userServiceInterface = userServiceInterface;
    }
    @GetMapping
    public String addPage(Model model){
        model.addAttribute("user",new User());
        return "addUser";
    }
    @PostMapping
    public String saveUser(User user){
        userServiceInterface.saveUser(user);
        return "redirect:/incomings";
    }
}
