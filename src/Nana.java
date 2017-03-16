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
		/*request�� �Էµ���, response�� ��µ��� =>�̰ɷ� sound,image�� ����� �ִ�.*/
		
		response.setCharacterEncoding("UTF-8"); //UTF-8�� ������
		response.setContentType("text/html; charset=UTF-8"); //�̰� �ϸ� ũ�ҵ� html�� ������ �ִ��.��  characterset������ ���� �д°�
		/*OutputStream os = response.getOutputStream();*/
		/*PrintStream out = new PrintStream(os);*/ //->1,2,3,4byte..�����ڸ� 1�� �����.. euc�� 2..utf��.. ����Ʈ�� ���ڰ� ��Ī��..�ȵ� Writer������ ����..
		/*out.println("Hello World 3");*/
		PrintWriter out=response.getWriter(); //�̰� ���� utf�� �ȱ�����.
		//(I/O)Stream: byte, Writer/Reader: char(���ڿ�����.. ����ƴѰ� ������!!)
		
		
		MemberDao memberDao =new MySQLMemberDao();
		List<Member> list = memberDao.getList("");
	    		
	    //==========view=========================
	    	    
		for(Member m:list)
			out.printf("���̵�� '%s' ��й�ȣ�� <span style='color:red;'>'%s'</span>\n<br/>",m.getId(),m.getPwd());
		
		/*------------------------------------------------------------------------------------------------*/
		response.setContentType("image/jpeg");//image..������ �ƴ�..
		String url="images/foto/lfcroom.jpg";
		ServletContext context=request.getServletContext();
		String path=context.getRealPath(url);
		//System.out.println(path);
		//��ȭ�� ������ ����
		//BufferedImage image= new BufferedImage(800,500,BufferedImage.TYPE_INT_RGB);
		
		//���ο� ��ȭ�� ���� -> ���ۼ� image java load�˻�
		BufferedImage image = ImageIO.read(new File(path));
		/*try {
		    image = ImageIO.read(new File(path));//�����ο� �����.. ���ݲ� �����..url����
		} catch (IOException e) {
		}*/
		/*try {
		    URL url = new URL("images/foto/������.jpg");
		    image = ImageIO.read(url);
		} catch (IOException e) {
		}*/
		
		Graphics g= image.createGraphics();
		
			//g.setColor(Color.white);
			//g.fillRect(0,0, 800, 500);
			/*g.setColor(Color.pink);
			g.drawLine(0, 0, 200, 200);*/
			g.setColor(Color.black);
			g.drawString("�ο�(��)", 150, 55);
			g.drawString("������뵵��(%)",450, 55);
			//�¿� ȭ��ǥ�߱�
			g.drawString("��",157, 65);
			g.drawLine(162, 65, 162, 400);
			g.drawString("��",380, 65);
			g.drawLine(485, 65, 485, 400);	
			//�Ʒ��� ȭ��ǥ�߱�
			g.drawString("��",490, 395);
			g.drawLine(160, 390, 490, 390);
			//�����߱�
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
