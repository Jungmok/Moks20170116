<%@page import="com.newlecture.web.data.view.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.data.dao.NoticeDao"%>
<%@page import="com.newlecture.web.dao.mysql.MySQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title=request.getParameter("title"); //_는 임시변수
	String content=request.getParameter("content");
	
	NoticeDao noticeDao = new MySQLNoticeDao();
	int result = noticeDao.add(title, content, "ynwa");
	
	if(result>0)
		//목록으로가기->출력도구로
		response.sendRedirect("notice.jsp");
%>
