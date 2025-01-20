/**
 * Clasa pentru configurarea securității aplicației.
 * Gestionează autentificarea și autorizarea utilizatorilor.
 *
 * @author David Leonard-Florin
 * @version 10 Decembrie 2024
 */

package upb.awj.demoSpringMH2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(
                "SELECT username, parola, activ FROM utilizatori WHERE username = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, rol FROM utilizatori WHERE username = ?");
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Dezactivează criptarea
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/resources/**", "/static/**", "/images/**", "/css/**", "/js/**", "/depozit1.jpg").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout") // Redirecționează utilizatorul după delogare
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")); // Permite GET pentru delogare
        return http.build();
    }

}
