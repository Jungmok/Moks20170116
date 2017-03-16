package com.newlecture.web.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chart
 */
@WebServlet("/Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
   	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("image/jpeg");
		String url="images/foto/lfcroom.jpg";
		ServletContext context=request.getServletContext();
		String path=context.getRealPath(url);
		
		//새로운 도화지 ㅋㅋ -> 구글서 image java load검색
		BufferedImage image = ImageIO.read(new File(path));
		
		Graphics g= image.createGraphics();
		
			g.setColor(Color.black);
			g.drawString("인원(명)", 150, 55);
			g.drawString("누적상대도수(%)",450, 55);
			//좌우 화살표긋기
			g.drawString("▲",157, 65);
			g.drawLine(162, 65, 162, 400);
			g.drawString("▲",480, 65);
			g.drawLine(485, 65, 485, 400);	
			//아래쪽 화살표긋기
			g.drawString("▶",490, 395);
			g.drawLine(160, 390, 490, 390);
			//점선긋기
			for(int j=0;j<5;j++)
				for(int i=0;i<65;i++){
					g.drawString("-", 162+5*i, 336-54*j);
					
				}
		
			int[] people=new int[]{2,4,6,8,10};
			int[] percent=new int[]{20,40,60,80,100};
			
			for(int i=0;i<5;i++)
				g.drawString(Integer.toString(people[i]),145,336-54*i);
			for(int i=0;i<5;i++)
				g.drawString(Integer.toString(percent[i]),490,336-54*i);
			g.drawString("You'll never walk alone!!", 530, 10);
			
		OutputStream os=response.getOutputStream();
		ImageIO.write(image, "jpg", os);
	}

}
