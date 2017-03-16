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
		request.setCharacterEncoding("UTF-8"); //�ö�..
		
		chain.doFilter(request, response);//�̰Ծ��� ���� ���Ͱ� ���� �ȵ�  html������ ��������� �ִ�
		
		response.setCharacterEncoding("UTF-8");
		//response.getWriter().print("ź�� ����");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
