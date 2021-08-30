package cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/login").anonymous()
                .antMatchers(HttpMethod.GET, "/cinema-halls")
                    .hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/cinema-halls").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/movies")
                    .hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/movie-sessions/available")
                    .hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/movie-sessions")
                    .hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/movie-sessions/{id}")
                    .hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/{id}")
                    .hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/orders")
                    .hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST, "/orders/complete")
                    .hasRole(USER_ROLE)
                .antMatchers(HttpMethod.POST, "/shopping-carts/movie-sessions")
                    .hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user")
                    .hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET, "/users/by-email")
                    .hasRole(ADMIN_ROLE)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
