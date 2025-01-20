package upb.awj.demoSpringMH2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import upb.awj.demoSpringMH2.model.Produs;
import upb.awj.demoSpringMH2.repository.ProdusRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoSpringMh2ApplicationTests {

	@Autowired
	private ProdusRepository produsRepository;

	@Test
	void contextLoads() {
		// Test simplu pentru a verifica încărcarea contextului Spring
		assertThat(produsRepository).isNotNull();
	}

	@Test
	void testAddProdus() {
		// Creăm un produs nou
		Produs produs = new Produs();
		produs.setNume("TestProdus");
		produs.setPret(99.99);
		produs.setDescriere("Descriere test produs");

		// Salvăm produsul
		Produs savedProdus = produsRepository.save(produs);

		// Verificăm dacă produsul a fost salvat cu succes
		assertThat(savedProdus.getId()).isNotNull();
		assertThat(savedProdus.getNume()).isEqualTo("TestProdus");
	}

	@Test
	void testUpdateProdus() {
		// Creăm și salvăm un produs
		Produs produs = new Produs();
		produs.setNume("ProdusInitial");
		produs.setPret(20.00);
		produs.setDescriere("Descriere inițială");
		Produs savedProdus = produsRepository.save(produs);

		// Actualizăm produsul
		savedProdus.setPret(25.00);
		savedProdus.setDescriere("Descriere actualizată");
		Produs updatedProdus = produsRepository.save(savedProdus);

		// Verificăm modificările
		assertThat(updatedProdus.getPret()).isEqualTo(25.00);
		assertThat(updatedProdus.getDescriere()).isEqualTo("Descriere actualizată");
	}

	@Test
	void testDeleteProdus() {
		// Creăm și salvăm un produs
		Produs produs = new Produs();
		produs.setNume("ProdusDeSters");
		produs.setPret(10.00);
		produs.setDescriere("Produs pentru ștergere");
		Produs savedProdus = produsRepository.save(produs);

		// Ștergem produsul
		produsRepository.deleteById(savedProdus.getId());

		// Verificăm dacă produsul a fost șters
		Optional<Produs> deletedProdus = produsRepository.findById(savedProdus.getId());
		assertThat(deletedProdus).isNotPresent();
	}
}
