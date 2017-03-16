import javax.imageio.ImageIO;
import javax.servlet.*;
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


public class Nana extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		/*request가 입력도구, response가 출력도구 =>이걸로 sound,image등 만들수 있다.*/
		
		response.setCharacterEncoding("UTF-8"); //UTF-8로 보내기
		response.setContentType("text/html; charset=UTF-8"); //이거 하면 크롬도 html로 받을수 있댄다.ㅋ  characterset설정도 가능 읽는거
		/*OutputStream os = response.getOutputStream();*/
		/*PrintStream out = new PrintStream(os);*/ //->1,2,3,4byte..영문자면 1로 충분함.. euc는 2..utf는.. 바이트와 글자가 매칭이..안됨 Writer쓸것을 권장..
		/*out.println("Hello World 3");*/
		PrintWriter out=response.getWriter(); //이거 쓰면 utf도 안깨진다.
		//(I/O)Stream: byte, Writer/Reader: char(문자열쓸때.. 영어아닌건 더더욱!!)
		
		
		MemberDao memberDao =new MySQLMemberDao();
		List<Member> list = memberDao.getList("");
	    		
	    //==========view=========================
	    	    
		for(Member m:list)
			out.printf("아이디는 '%s' 비밀번호는 <span style='color:red;'>'%s'</span>\n<br/>",m.getId(),m.getPwd());
		
		/*------------------------------------------------------------------------------------------------*/
		response.setContentType("image/jpeg");//image..웹문서 아님..
		String url="images/foto/lfcroom.jpg";
		ServletContext context=request.getServletContext();
		String path=context.getRealPath(url);
		//System.out.println(path);
		//도화지 같은거 ㅋㅋ
		//BufferedImage image= new BufferedImage(800,500,BufferedImage.TYPE_INT_RGB);
		
		//새로운 도화지 ㅋㅋ -> 구글서 image java load검색
		BufferedImage image = ImageIO.read(new File(path));
		/*try {
		    image = ImageIO.read(new File(path));//절대경로와 상대경로.. 지금껀 상대경로..url형태
		} catch (IOException e) {
		}*/
		/*try {
		    URL url = new URL("images/foto/ㅈ간지.jpg");
		    image = ImageIO.read(url);
		} catch (IOException e) {
		}*/
		
		Graphics g= image.createGraphics();
		
			//g.setColor(Color.white);
			//g.fillRect(0,0, 800, 500);
			/*g.setColor(Color.pink);
			g.drawLine(0, 0, 200, 200);*/
			g.setColor(Color.black);
			g.drawString("인원(명)", 150, 55);
			g.drawString("누적상대도수(%)",450, 55);
			//좌우 화살표긋기
			g.drawString("▲",157, 65);
			g.drawLine(162, 65, 162, 400);
			g.drawString("▲",380, 65);
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
		/*JPEGImageEncoder encoder = JPEGCodec.createJPEGDecoder(os);
		encoder.encode(image);*/
	}
}
