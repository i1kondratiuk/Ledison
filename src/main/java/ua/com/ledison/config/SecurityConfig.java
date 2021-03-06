package ua.com.ledison.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan("ua.com.ledison.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth,
	                            AuthenticationProvider provider) throws Exception {
		inMemoryConfigure()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN")
				.and()
				.configure(auth);
		auth.authenticationProvider(provider);
	}

	private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigure() {
		return new InMemoryUserDetailsManagerConfigurer<>();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/", "/home", "/product/*", "/rest/*").permitAll()
		    .antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
		    .antMatchers("/customer/*").access("hasRole('ROLE_USER')").and()
		    .formLogin().loginPage("/login")
		    .usernameParameter("username").passwordParameter("password").and()
		    .logout().logoutUrl("/logout")
		    .logoutSuccessUrl("/home")
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
		    .exceptionHandling().accessDeniedPage("/accessDenied").and()
		    .csrf().disable();
	}
}
