package com.newlecture.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    public void destroy() {
	}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("Filter");
		request.setCharacterEncoding("UTF-8"); //올때..
		
		chain.doFilter(request, response);//이게없음 다음 필터가 실행 안됨  html조차도 묶어버릴수 있는
		
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().print("탄핵 ㅅㅅ");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
