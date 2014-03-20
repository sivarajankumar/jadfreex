package net.jadfreex.commons.cors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {

    public static HttpHeaders addAccessControlAllowOrigin() {
	HttpHeaders headers = new HttpHeaders();
	headers.add("Access-Control-Allow-Origin", "*");
	return headers;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request,
	    HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException {
	// if (request.getHeader("Access-Control-Request-Method") != null
	// && "OPTIONS".equals(request.getMethod())) {
	response.addHeader("Access-Control-Allow-Origin", "*");
	response.addHeader("Access-Control-Allow-Methods",
		"OPTIONS, GET, POST, PUT, DELETE");
	response.addHeader("Access-Control-Allow-Headers", "Content-Type");
	response.addHeader("Access-Control-Max-Age", "3600");
	// }
	filterChain.doFilter(request, response);
    }
}