/**
 * Clasa pentru gestionarea autentificării utilizatorilor.
 * Controlează afișarea paginii de login.
 *
 * @author David Leonard-Florin
 * @version 10 Decembrie 2024
 */

package upb.awj.demoSpringMH2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Numele fișierului Thymeleaf (login.html)
    }
}


