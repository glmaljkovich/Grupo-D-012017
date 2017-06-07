package grupod.desapp.unq.edu.ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/home")
    @ResponseBody
    public ModelAndView index(Model model) {
        return new ModelAndView("home");
    }

}
