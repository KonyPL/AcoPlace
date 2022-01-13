package put.poznan.AcoPlace.admin.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import put.poznan.AcoPlace.admin.model.AdminUser;
import put.poznan.AcoPlace.admin.repository.AdminUserRepository;

@Controller
public class SecurityController {

    private AdminUserRepository userRepo;

    public SecurityController(AdminUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new AdminUser());

        return "signupForm";
    }

    @PostMapping("/process_register")
    public String processRegister(AdminUser user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //TODO przy save dać flage actie na false
        userRepo.save(user);

        return "registerSuccess";
    }
}
