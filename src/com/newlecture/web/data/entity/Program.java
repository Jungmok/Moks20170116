package com.newlecture.web.data.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.dao.mysql.MySQLMemberDao;
import com.newlecture.web.dao.oracle.OracleMemberDao;
import com.newlecture.web.data.dao.MemberDao;


public class Program {

	public static void main(String[] args){
	
		//================Controller==================
		
		//jdbc.dao�� �ѰŴ� ��
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�Է��ϼ��� �� : ");
		String query= scan.nextLine();
		
		MemberDao memberDao =new MySQLMemberDao();
		List<Member> list = memberDao.getList(query);
	    
		
		
	    //==========model->����� ������ ��Ƴ��� ��==========
	    
	    
	    //==========view=========================
	    
	    //if(mid.contains("a"))
		
		
		
		for(Member m:list)
			System.out.printf("���̵�� '%s' ��й�ȣ�� '%s'\n",m.getId(),m.getPwd());		    
	    
		/*Member t = new Member();
		t.setId("LiverpoolFC");
		t.setPwd("1982");
		t.setName("��������");
		
		memberDao.add(t);
		
		list = memberDao.getList(query);
	    
		System.out.println("---------------------------------------------------");
		
		for(Member m:list)
			System.out.printf("���̵�� '%s' ��й�ȣ�� '%s'\n",m.getId(),m.getPwd());*/
	    
	   /*rs.next();
	    //������ �ִ� ���ڵ� �ϳ� �����
	    String mid1;
	    mid1 = rs.getString("MID");
	    System.out.println(mid1);*/

	}

}
