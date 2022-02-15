package br.com.examplesecurity.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			httpBasic()
        .and()
        	.authorizeRequests()
        	.antMatchers("/h2-console/**").permitAll() // caso use o H2 como data base.
        	.antMatchers("/hello").hasAnyAuthority("ADM", "USER") // Permite que o usuario ADM e o User tenham acesso.
        	.antMatchers("/adm").hasAnyAuthority("ADM")// Permite o usuário com role ADM o acesso.
        .and()
        	.formLogin(form -> form
        		.loginPage("/login")// URL da pagina de login
        		.defaultSuccessUrl("/home", true) //pagina usada para abrir ao se autenticar
        		.permitAll() // todos são permitidos acessar a pagina de login
        		).csrf().disable();
		http.headers().frameOptions().disable();
	}
	/*
	 * Ultilizado pelo Spring security
	 * */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
