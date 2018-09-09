package br.com.same.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import br.com.same.security.SecurityConfig;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {
		super(new Class[]{SecurityConfig.class});
	}
}