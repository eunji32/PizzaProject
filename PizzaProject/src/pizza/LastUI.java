package pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class LastUI extends JFrame implements MouseListener{
	BorderLayout border = new BorderLayout();
	JButton backbutton;
	JButton endButton;
	
	LastUI(){
		// 프레임 배경색
		this.getContentPane().setBackground(Color.white); 
		
		//이미지
		ImageIcon logo = new ImageIcon("./images/logo.jpg");
		ImageIcon lastimage = new ImageIcon("./images/lastimage.jpg");
		ImageIcon backicon = new ImageIcon("./images/backicon.jpg");
		ImageIcon endicon = new ImageIcon("./images/endicon.png");
		
		Container container = getContentPane();
		container.setLayout(null);
		
		JLabel lab1 = new JLabel(logo);
		lab1.setBounds(90,45,logo.getIconWidth(),logo.getIconHeight());
		JLabel lab2 = new JLabel(lastimage);
		lab2.setBounds(50,115,lastimage.getIconWidth(),lastimage.getIconHeight());
		
		
		
		// 뒤로가기 버튼
		backbutton = new JButton(backicon);
		backbutton.setBounds(350,630,backicon.getIconWidth(),backicon.getIconHeight());
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		backbutton.addMouseListener(this);
		
		
		// 종료버튼
		endButton = new JButton(endicon);
		endButton.setBounds(106, 394, endicon.getIconWidth(), endicon.getIconHeight());
//		endButton.setContentAreaFilled(false);
//		endButton.setBorderPainted(true);
		endButton.addMouseListener(this);
		//106.394
		
		
		container.add(endButton);
		container.add(lab1);
		container.add(lab2);
		container.add(backbutton);
//		lab2.add(endButton);
		
		
		// 컨테이너 
		setTitle("주문해주셔서 감사합니다 ^^~");
		setSize(400,700); 
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == backbutton) {
			new FirstUI();
			this.dispose();
		}
		else {
			this.dispose();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}


