package com.newlecture.web.servlet;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.applet.Applet;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;
import com.sun.image.codec.jpeg.*;

@WebServlet("/memberlist")
public class MemberList extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		/*request가 입력도구, response가 출력도구 =>이걸로 sound,image등 만들수 있다.*/
		
		String query=request.getParameter("query");
		System.out.println(query);
		
		response.setCharacterEncoding("UTF-8"); //UTF-8로 보내기
		response.setContentType("text/html; charset=UTF-8"); //이거 하면 크롬도 html로 받을수 있댄다.ㅋ  characterset설정도 가능 읽는거
		/*OutputStream os = response.getOutputStream();*/
		/*PrintStream out = new PrintStream(os);*/ //->1,2,3,4byte..영문자면 1로 충분함.. euc는 2..utf는.. 바이트와 글자가 매칭이..안됨 Writer쓸것을 권장..
		/*out.println("Hello World 3");*/
		PrintWriter out=response.getWriter(); //이거 쓰면 utf도 안깨진다.
		//(I/O)Stream: byte, Writer/Reader: char(문자열쓸때.. 영어아닌건 더더욱!!)
		
		
		MemberDao memberDao =new MySQLMemberDao();
		List<Member> list = memberDao.getList(query);
	    		
	    //==========view=========================
	    	    
		for(Member m:list)
			out.printf("아이디는 '%s' 비밀번호는 <span style='color:red;'>'%s'</span>\n<br/>",m.getId(),m.getPwd());
		
		/*------------------------------------------------------------------------------------------------*/
		
	}
}
