package com.aj.mvc1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

 /*  @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .requestMatchers("","/","/home").permitAll()
               .requestMatchers("/contact").permitAll()
               .and().formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }*/

   /* @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }*/

      /* @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }*/

   /* @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().denyAll()
                .and().formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }*/


    /**
     * /home
     * /contact
     * /about
     * /holidays
     * /saveMsg
     * /course
     */
   /*  @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("","/","/home").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/course").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .and().formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }*/
    /*@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //CSRF--> Cross Site Request Forgery

        http.csrf((csrfVar) -> csrfVar.disable())
                .authorizeRequests()
                .requestMatchers("", "/", "/home").authenticated()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/course").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .and().formLogin(Customizer.withDefaults()).loginPage("/login")
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }*/

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //CSRF--> Cross Site Request Forgery

        http
                .csrf((csrfVar) -> csrfVar.ignoringRequestMatchers("/saveMsg"))
                .authorizeRequests()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("", "/", "/home").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/course").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
                .and().formLogin(
                        loginConfigure->loginConfigure.loginPage("/login").defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigure->logoutConfigure.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("karan")
                .password("123")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
