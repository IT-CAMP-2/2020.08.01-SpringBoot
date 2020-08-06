package pl.camp.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

    @RequestMapping(value = "/reakcja", method = RequestMethod.GET)
    public String jakasReakcja() {
        System.out.println("Odpaliła się reakcja !!");
        return "reakcja";
    }

    @RequestMapping(value = "/reakcja2", method = RequestMethod.GET)
    public String jasydgfkjs() {
        System.out.println("Jakas reakcja 2 !!");
        return "reakcja";
    }
}
