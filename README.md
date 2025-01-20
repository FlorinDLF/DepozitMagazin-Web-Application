# DepozitMagazin-Web-Application
Aplicatie web pentru depozitul unui magazin folosind Java, SQL, HTML si CSS

## Descriere Generală
DepozitMagazin-Web-Application este o aplicație web pentru gestionarea eficientă a unui depozit de produse. Aplicația oferă funcționalități pentru afișarea, adăugarea, editarea și ștergerea produselor din stoc. Este destinată utilizatorilor care gestionează stocuri într-un depozit și au nevoie de o interfață simplă, intuitivă și ușor de utilizat.

Aplicația este construită utilizând **Spring Boot**, **Thymeleaf**, **SQL Server** și tehnologii front-end precum **HTML**, **CSS** și **JavaScript**.

---

## Funcționalități
### 1. **Gestionarea Produselor**
- **Vizualizare Produse**: Afișarea tuturor produselor din depozit într-un tabel.
- **Adăugare Produs**: Posibilitatea de a adăuga produse noi în depozit printr-un formular.
- **Editare Produs**: Modificarea detaliilor unui produs existent.
- **Ștergere Produs**: Eliminarea unui produs din depozit.

### 2. **Autentificare și Autorizare**
- Sistemul permite accesul doar utilizatorilor autentificați.
- Utilizatorii trebuie să se conecteze cu un nume de utilizator și o parolă.
- Existența rolurilor utilizatorilor permite extensii viitoare pentru diferite niveluri de acces.

### 3. **Validări**
- Validare automată a datelor de intrare:
  - **Nume produs**: Nu poate fi gol.
  - **Preț produs**: Trebuie să fie un număr pozitiv, mai mare de `0.01`.
- Gestionarea erorilor prin afișarea de mesaje clare în interfața grafică.

### 4. **Interfață Grafică**
- **Responsive Design**: Se adaptează pentru diferite dimensiuni ale ecranului.
- **Interfață Intuitivă**: Oferă o experiență prietenoasă pentru utilizator, cu butoane bine definite și stiluri moderne.

---

## Scopul Proiectului
Proiectul are ca scop dezvoltarea unei soluții software simplificate pentru gestionarea depozitelor de produse. Acesta poate fi utilizat de operatorii depozitelor pentru a gestiona în mod eficient stocurile, evitând problemele legate de documentația fizică sau manuală.

---

## Utilizare
1. **Autentificare**
   - Accesați aplicația la URL-ul: [http://localhost:8080](http://localhost:8080).
   - Introduceți un nume de utilizator și o parolă valide:
     - `admin` / `parola`
     - `testuser` / `parola`

2. **Vizualizare Produse**
   - După autentificare, veți fi redirecționat automat către pagina principală care afișează toate produsele existente.

3. **Adăugare Produs**
   - Completați câmpurile din formular (nume, preț, descriere) și apăsați butonul **Salvează**.

4. **Editare Produs**
   - Apăsați butonul **Editează** de lângă produsul dorit.
   - Modificați detaliile și apăsați **Salvează**.

5. **Ștergere Produs**
   - Apăsați butonul **Șterge** și confirmați acțiunea.

---

## Structura Proiectului
1. **Backend**
   - Limbaj: **Java (Spring Boot)**.
   - Controller-e principale:
     - `HomeController`: Redirecționează utilizatorii către pagina principală.
     - `LoginController`: Gestionează autentificarea utilizatorilor.
     - `ProdusController`: Oferă operațiunile CRUD pentru entitatea produs.
   - Validări prin anotări Javax (`@NotBlank`, `@DecimalMin`).

2. **Frontend**
   - Tehnologii: **HTML**, **CSS**, **Thymeleaf**.
   - Pagini:
     - `login.html`: Pagina de autentificare.
     - `produse.html`: Pagina principală pentru gestionarea produselor.
     - `editProdus.html`: Pagina pentru editarea produselor.

3. **Bază de Date**
   - Tip: **SQL Server 2014**.
   - Tabele:
     - `utilizatori`: Stochează utilizatorii aplicației (username, parolă, rol, activ).
     - `produse`: Stochează informații despre produse (id, nume, preț, descriere).

---

## Validări și Testări
1. **Validări Formulare**
   - Datele introduse de utilizator sunt validate la nivel de server.
   - Erorile sunt afișate direct în interfață.

2. **Testare Unită**
   - Fișierul `DemoSpringMh2ApplicationTests` include teste pentru încărcarea contextului aplicației.
   - Extensii viitoare pentru testarea operațiunilor CRUD.

3. **Testare Funcțională**
   - Toate funcționalitățile au fost verificate manual într-un mediu local.

---

## Îmbunătățiri Viitoare
1. **Căutare Produse**: Implementarea unui câmp de căutare pentru a filtra produsele după nume.
2. **Export Raport**: Funcționalitate pentru exportarea listei de produse în format CSV/PDF.
3. **Autorizare Extinsă**: Adăugarea de niveluri de acces pentru utilizatori (ex. Admin, Manager).
4. **Istoric Modificări**: Înregistrarea modificărilor efectuate asupra produselor.
5. **Notificări Stoc**: Alerte pentru stocuri scăzute.

---

## Cerințe pentru Rulare
- **Java 17** sau o versiune mai recentă.
- **SQL Server 2014**.
- **Maven** pentru gestionarea dependențelor.
