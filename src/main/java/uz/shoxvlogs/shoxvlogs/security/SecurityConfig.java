package uz.shoxvlogs.shoxvlogs.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final uz.shoxvlogs.shoxvlogs.security.SecurityFilter securityFilter;
    private final UserProvider userProvider;
    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    public SecurityConfig(SecurityFilter securityFilter, UserProvider userProvider, JwtAuthenticationEntryPoint unauthorizedHandler) {
        this.securityFilter = securityFilter;
        this.userProvider = userProvider;
        this.unauthorizedHandler = unauthorizedHandler;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().and().csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/api/account/signin").permitAll()
                .antMatchers("/api/account/signup").permitAll()
                .antMatchers(HttpMethod.GET,  "/api/fail/download/**").permitAll()

                .antMatchers(HttpMethod.GET, "/api/new").permitAll()

                .antMatchers(HttpMethod.GET, "/api/onlinenew").permitAll()

                .antMatchers(HttpMethod.GET, "/api/reklama").permitAll()

                .antMatchers(HttpMethod.GET, "/api/starnew").permitAll()

                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// 		Add a filter to validate the tokens with every request
        http.addFilterBefore(securityFilter,
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("http://localhost:5500");
        config.addAllowedOrigin("http://localhost:5501");
        config.addAllowedOrigin("http://localhost:5502");
        config.addAllowedOrigin("http://192.168.43.144:4200");
        config.addAllowedOrigin("http://192.168.100.233:4200");
        config.addAllowedOrigin("https://shoxvlogs.uz");
        config.addAllowedOrigin("https://api.shoxvlogs.uz");
        config.addAllowedOrigin("https://admin.shoxvlogs.uz");

        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
