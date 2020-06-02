package pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;





class FirstUI extends JFrame implements ActionListener{
//	PizzaPickView pzview = new PizzaPickView();
	BorderLayout border = new BorderLayout();
	JButton button;
//	Container container;
	JButton secertBu;
	
	
	

	
	FirstUI(){
		// 패널이미지
		
		this.getContentPane().setBackground(Color.white); // 프레임 배경색 지정
		ImageIcon main1 = new ImageIcon("./images/main1.jpg");	
		ImageIcon icon1 = new ImageIcon("./images/icon1.jpg");			
		ImageIcon main2 = new ImageIcon("./images/main2.jpg");			
		ImageIcon order = new ImageIcon("./images/order.jpg");			

		Container container = getContentPane();
		container.setLayout(null);
		
		secertBu = new JButton();
		secertBu.setBounds(350, 620, 50, 50);
		secertBu.setVisible(true);
		secertBu.addActionListener(this);
		secertBu.setBorderPainted(false);
		secertBu.setBackground(new Color(255, 255, 255));
		
		JLabel label = new JLabel(main1);
		label.setBounds(0,70,main1.getIconWidth(),main1.getIconHeight());
		JLabel lab1 = new JLabel(icon1);
		lab1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
		JLabel lab2 = new JLabel(main2);
		lab2.setBounds(0,224,main2.getIconWidth(),main2.getIconHeight());

		// 버튼00
		//hhh
		int width = 400;
		int height = 700;
		 button = new JButton(order);
		 button.setBounds(100, 430,order.getIconWidth(),order.getIconHeight());
//		 button.setContentAreaFilled(false);
		 button.setBorderPainted(false);
		 button.addActionListener(this);
		 
		 
		 container.add(label);
		 container.add(lab1);
		 container.add(lab2);
		 container.add(button);
		 container.add(secertBu);
	
	
		
		// 컨테이너 
		setTitle("피 자");
		setSize(400,700); 
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(secertBu)) {
			this.dispose();
			new ManagerLogin();
		}else {
			new PizzaPickUI();
			this.dispose();
		}
		
		
		
		
	}


	
	
	
}
