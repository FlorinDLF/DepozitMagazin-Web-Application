/**
 * Clasa pentru entitatea Produs.
 * Reprezintă un produs în baza de date, incluzând câmpuri precum nume, preț și descriere.
 *
 * @author David Leonard-Florin
 * @version 10 Decembrie 2024
 */

package upb.awj.demoSpringMH2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Produse")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele nu poate fi gol")
    @Column(name = "nume", nullable = false)
    private String nume;

    @NotNull(message = "Prețul nu poate fi gol.")
    @DecimalMin(value = "0.01", message = "Prețul trebuie să fie mai mare de 0.")
    private Double pret;

    @Column(name = "descriere")
    private String descriere;

    // Getters și Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
