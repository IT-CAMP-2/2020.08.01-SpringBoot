package pl.camp.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    List<User> users = new ArrayList<>();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        System.out.println(user);
        user.setId(users.size()+1);
        users.add(user);
        return "reakcja";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, Model model) {
        User user = null;
        for (User tempUser : users) {
            if(tempUser.getId() == id) {
                user = tempUser;
                break;
            }
        }

        model.addAttribute("user", user);
        /*if(user == null) {
            model.addAttribute("isUser", false);
        } else {
            model.addAttribute("isUser", true);
        }*/

        model.addAttribute("isUser", !(user==null));

        return "user";
    }
}
