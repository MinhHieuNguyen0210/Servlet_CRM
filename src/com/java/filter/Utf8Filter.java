package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/home")

public class Utf8Filter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Code xu ly request
		request.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);

		// Code xu ly response

		response.setCharacterEncoding("UTF-8");
	}

}
