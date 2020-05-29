package Pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class LastUI extends JFrame{
	BorderLayout border = new BorderLayout();
	JButton button;
	
	
	LastUI(){
		// 프레임 배경색
		this.getContentPane().setBackground(Color.white); 
		
		//이미지
		ImageIcon logo = new ImageIcon("./images/logo.jpg");
		ImageIcon lastimage = new ImageIcon("./images/lastimage.jpg");
		ImageIcon backicon = new ImageIcon("./images/backicon.jpg");
		
		Container container = getContentPane();
		container.setLayout(null);
		
		JLabel lab1 = new JLabel(logo);
		lab1.setBounds(90,45,logo.getIconWidth(),logo.getIconHeight());
		JLabel lab2 = new JLabel(lastimage);
		lab2.setBounds(50,115,lastimage.getIconWidth(),lastimage.getIconHeight());
		
		// 버튼
		button = new JButton(backicon);
		button.setBounds(350,630,backicon.getIconWidth(),backicon.getIconHeight());
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		
		container.add(lab1);
		container.add(lab2);
		container.add(button);
		
		
		
		// 컨테이너 
		setTitle("도미노 피자 ");
		setSize(400,700); 
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
			
	}	
}


