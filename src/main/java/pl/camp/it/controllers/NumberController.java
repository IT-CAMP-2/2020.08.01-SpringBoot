package pl.camp.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class NumberController {

    @RequestMapping(value = "/number", method = RequestMethod.GET)
    public String showNumbers(Model model) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
           numbers.add(random.nextInt(101));
        }

        model.addAttribute("numbers", numbers);
        model.addAttribute("boolean", random.nextBoolean());

        return "numbers";
    }

    @RequestMapping(value = "/number/{number}", method = RequestMethod.GET)
    public String confirmNumber(@PathVariable int number, Model model) {
        System.out.println(number);
        model.addAttribute("number", number);
        return "number"; //nazwa pliku html
    }
}
