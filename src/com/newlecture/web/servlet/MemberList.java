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
		/*request�� �Էµ���, response�� ��µ��� =>�̰ɷ� sound,image�� ����� �ִ�.*/
		
		String query=request.getParameter("query");
		System.out.println(query);
		
		response.setCharacterEncoding("UTF-8"); //UTF-8�� ������
		response.setContentType("text/html; charset=UTF-8"); //�̰� �ϸ� ũ�ҵ� html�� ������ �ִ��.��  characterset������ ���� �д°�
		/*OutputStream os = response.getOutputStream();*/
		/*PrintStream out = new PrintStream(os);*/ //->1,2,3,4byte..�����ڸ� 1�� �����.. euc�� 2..utf��.. ����Ʈ�� ���ڰ� ��Ī��..�ȵ� Writer������ ����..
		/*out.println("Hello World 3");*/
		PrintWriter out=response.getWriter(); //�̰� ���� utf�� �ȱ�����.
		//(I/O)Stream: byte, Writer/Reader: char(���ڿ�����.. ����ƴѰ� ������!!)
		
		
		MemberDao memberDao =new MySQLMemberDao();
		List<Member> list = memberDao.getList(query);
	    		
	    //==========view=========================
	    	    
		for(Member m:list)
			out.printf("���̵�� '%s' ��й�ȣ�� <span style='color:red;'>'%s'</span>\n<br/>",m.getId(),m.getPwd());
		
		/*------------------------------------------------------------------------------------------------*/
		
	}
}
