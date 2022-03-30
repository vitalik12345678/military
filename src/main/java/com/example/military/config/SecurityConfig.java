package com.example.military.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserPrincipalDetailsService userPrincipalDetailsService;

    @Autowired
    public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
/* http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/registration", "/logout").hasAnyRole("user","medic","admin")
                .antMatchers("/api/admin**","/admin/**").hasAuthority("admin")
                .antMatchers("/api/medic**","/medic/**").hasAuthority("medic")
                .and()
                .formLogin()
                .loginProcessingUrl("/api/login")
                .loginPage("/login")
                .permitAll()
                .usernameParameter("emailInput")
                .passwordParameter("passwordInput")
                .and()
                .logout()
                .logoutSuccessUrl("/");

  http
                .authorizeRequests()
                .antMatchers("/api/user/v1/fsa/**").hasAnyRole("user","medic","admin")
                .and()
                .httpBasic();*/

        http.
                csrf().disable().
                authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .httpBasic().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        provider.setUserDetailsService(this.userPrincipalDetailsService);
        return provider;
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}