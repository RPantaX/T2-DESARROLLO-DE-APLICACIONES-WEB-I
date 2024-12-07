package pe.edu.cibertec.DAAI_T2_PantaJefferson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.impl.DetalleUsuarioServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private DetalleUsuarioServiceImpl detalleUsuarioService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/auth/login").permitAll();
            auth.requestMatchers("/auth/register").permitAll();
            auth.anyRequest().authenticated();
        });

        http.formLogin(login -> {
           login.loginPage("/auth/login");
           login.loginProcessingUrl("/auth/login");
           login.defaultSuccessUrl("/auth/login-success", true);
           login.usernameParameter("username");
           login.passwordParameter("password");
        });

        http.logout(logout -> {
           logout.logoutSuccessUrl("/auth/login?logout")
                   .invalidateHttpSession(true);
        });
        http.authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(detalleUsuarioService);
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
