/**
 * Clasa pentru gestionarea paginii principale a aplicației.
 * Asigură redirecționarea utilizatorilor autentificați către pagina de start.
 *
 * @author David Leonard-Florin
 * @version 10 Decembrie 2024
 */

package upb.awj.demoSpringMH2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/produse";
    }
}
