package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.Authority;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUser {

    @Autowired
    UserService userService;

    @GetMapping("/editUser/{userId}/{userRole}")
    public String editProduct(@PathVariable("userId") int userId, @PathVariable("userRole") String userRole, Model model) {
        User user = userService.findById(userId);
        user.getAuthorities();

        user.setAuthority(Authority.valueOf(userRole));
        userService.updateUser(user);
        model.addAttribute("user", user);

        return "userManagement";
    }

}
