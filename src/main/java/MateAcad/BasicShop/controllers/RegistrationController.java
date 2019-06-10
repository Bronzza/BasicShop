
package MateAcad.BasicShop.controllers;

import MateAcad.BasicShop.Entities.User;
import MateAcad.BasicShop.enums.Role;
import MateAcad.BasicShop.services.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final UserServiceImplementation userService;

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user)
                .setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, Map<String, Object> model) {
        User userDataBase = userService.getByUserName(user.getUsername());

        if (userDataBase != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        System.out.println(user.getClass());
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(user);
        return "redirect:/login";
    }
}

