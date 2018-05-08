package org.missaoui.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

/*@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM = "MY_BASIC_AUTHENTICATION";

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sadek").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/rest/**").hasRole("ADMIN")
        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new CustomBasicAuthenticationEntryPoint();
	}
	
}*/


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("loginDetailsService")
	UserDetailsService loginDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin/**","/abonne/**","/index/admin**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/abonne/**","/index/abonne**").access("hasRole('ROLE_USER')")
			.and().formLogin()
			.loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout().logoutSuccessUrl("/login?logout")
				.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}