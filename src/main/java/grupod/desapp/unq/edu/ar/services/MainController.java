package grupod.desapp.unq.edu.ar.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "<h1>Yopping </h1>" +
                "<i> Una app para listas de compras </i>";
    }

}
