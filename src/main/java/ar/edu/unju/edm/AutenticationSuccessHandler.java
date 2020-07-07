package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean tipoBD = false;
		boolean tipoConsultor = false;
		boolean tipoRegistrador = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("Bd")) {
				tipoBD = true;
				break;
			} else {
				if (grantedAuthority.getAuthority().equals("Consultor")) {
					tipoConsultor = true;
					break;
				} else {
					tipoRegistrador = true;
					break;
				}
			}
		}
		if (tipoBD) {
			redirectStrategy.sendRedirect(request, response, "/indexBD");
		} else {
			if (tipoConsultor) {
				redirectStrategy.sendRedirect(request, response, "/indexConsultor");
			} else {
				if (tipoRegistrador) {
					redirectStrategy.sendRedirect(request, response, "/indexRegistrador");
				} else {
					throw new IllegalStateException();
				}
			}
		}
	}

}
