/**
 * Clasa pentru gestionarea operațiunilor CRUD ale produselor.
 * Controlează afișarea, adăugarea, editarea și ștergerea produselor.
 *
 * @author David Leonard-Florin
 * @version 10 Decembrie 2024
 */

package upb.awj.demoSpringMH2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upb.awj.demoSpringMH2.model.Produs;
import upb.awj.demoSpringMH2.repository.ProdusRepository;
import jakarta.validation.Valid;

@Controller
public class ProdusController {

    @Autowired
    private ProdusRepository produsRepository;

    @GetMapping("/produse")
    public String getProduse(Model model) {
        model.addAttribute("produs", new Produs());
        model.addAttribute("produse", produsRepository.findAll());
        return "produse";
    }

    @PostMapping("/addProdus")
    public String addProdus(@Valid Produs produs, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Reîncărcăm pagina cu lista de produse și mesajele de eroare
            model.addAttribute("produse", produsRepository.findAll());
            return "produse";
        }

        // Dacă nu există erori, salvăm produsul și redirecționăm la pagina principală
        produsRepository.save(produs);
        return "redirect:/produse";
    }

    @PostMapping("/updateProdus")
    public String updateProdus(@Valid Produs produs, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Reîncărcăm pagina de editare cu mesajele de eroare
            model.addAttribute("produs", produs);
            return "editProdus";
        }
        produsRepository.save(produs);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProdus(@RequestParam("id") Long id, Model model) {
        if (id == null || !produsRepository.existsById(id)) {
            model.addAttribute("errorMessage", "Produsul nu există sau ID-ul este invalid!");
            model.addAttribute("produse", produsRepository.findAll());
            return "produse";
        }

        produsRepository.deleteById(id);
        return "redirect:/produse";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Produs produs = produsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produs invalid"));
        model.addAttribute("produs", produs); // Obiect populat pentru editare
        return "editProdus"; // Numele paginii HTML pentru editare
    }
}
