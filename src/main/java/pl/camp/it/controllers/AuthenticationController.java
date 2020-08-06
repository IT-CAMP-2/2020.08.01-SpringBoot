package pl.camp.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String formProcessing(@RequestParam String login,
                                 @RequestParam String password,
                                 Model model) {

        System.out.println(login);
        System.out.println(password);
        model.addAttribute("mojLogin", login);
        model.addAttribute("mojeHaslo", password);
        model.addAttribute("number", new Random().nextInt(101));
        return "main";
    }

    @RequestMapping(value = "/addressParams/{parametr}/{parametr2}", method = RequestMethod.GET)
    public String addressParams(@PathVariable int parametr,
                                @PathVariable String parametr2) {
        System.out.println(parametr);
        System.out.println(parametr2);
        return "reakcja";
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String address(@RequestParam String user) {
        System.out.println(user);
        return "reakcja";
    }
}
