package Pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PizzaPickView extends JFrame {
	PizzaPickControl ppc = new PizzaPickControl();
	
	PizzaPickView(){
		
		Container container = getContentPane();	
		container.setLayout(new BorderLayout());
		
		//북쪽패널
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1,3));
		jp1.setPreferredSize(new Dimension(400, 100));
		JLabel bin = new JLabel(new ImageIcon("./images/bin.png"));
		JLabel logo = new JLabel(new ImageIcon("./images/logo.png"));
		JButton chart = new JButton(new ImageIcon("./images/chart.png"));
		chart.setBorderPainted(false);
		chart.setContentAreaFilled(false);
		chart.setFocusPainted(false);
		jp1.add(bin);	  
        jp1.add(logo);	  
        jp1.add(chart);	  
        jp1.setBackground(Color.white);
		  

      //센터패널
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout(2, 4, 10, 10));
		jp2.setBackground(Color.white);
		
		//토핑탑텐
		ImageIcon topten = new ImageIcon("./images/topten.png");
		ImageIcon toptenb = new ImageIcon("./images/topten2.png");
		ImageIcon toptenc = new ImageIcon("./images/topten2.png");
		JButton pizza1 = new JButton(topten);
		pizza1.setBorderPainted(false);
		pizza1.setContentAreaFilled(false);
		pizza1.setFocusPainted(false);
		pizza1.setRolloverIcon(toptenb);
		pizza1.setPressedIcon(toptenc);
		jp2.add(pizza1);
		
		//미트미트미트
		ImageIcon meat = new ImageIcon("./images/meat.png");
		ImageIcon meatb = new ImageIcon("./images/meat2.png");
		ImageIcon meatc = new ImageIcon("./images/meat3.png");
		JButton pizza2 = new JButton(meat);
		pizza2.setBorderPainted(false);
		pizza2.setContentAreaFilled(false);
		pizza2.setFocusPainted(false);
		pizza2.setRolloverIcon(meatb);
		pizza2.setPressedIcon(meatc);
		jp2.add(pizza2);
	     
	
		//치즈&뉴욕 스트립 스테이크
		ImageIcon steak = new ImageIcon("./images/steak.png");
		ImageIcon steakb = new ImageIcon("./images/steak2.png");
		ImageIcon steakc = new ImageIcon("./images/steak2.png");
		JButton pizza3 = new JButton(steak);
		pizza3.setBorderPainted(false);
		pizza3.setContentAreaFilled(false);
		pizza3.setFocusPainted(false);
		pizza3.setRolloverIcon(steakb);
		pizza3.setPressedIcon(steakc);
		jp2.add(pizza3);
		
		//블랙타이거 쉬림프
		ImageIcon shrim = new ImageIcon("./images/shrim.png");
		ImageIcon shrimb = new ImageIcon("./images/shrim2.png");
		ImageIcon shrimc = new ImageIcon("./images/shrim2.png");
		JButton pizza4 = new JButton(shrim);
		pizza4.setBorderPainted(false);
		pizza4.setContentAreaFilled(false);
		pizza4.setFocusPainted(false);
		pizza4.setRolloverIcon(shrimb);
		pizza4.setPressedIcon(shrimc);
		jp2.add(pizza4);
        
        
		//남쪽패널
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		jp3.setBackground(Color.white);
		jp3.setPreferredSize(new Dimension(400,50));
		JLabel dot = new JLabel(new ImageIcon("./images/dot.png"));
		jp3.add(dot);
		
		
		//동서패널
		JPanel jp4 = new JPanel();
		jp4.setLayout(new GridLayout());
		jp4.setPreferredSize(new Dimension(50, 500));
		jp4.setBackground(Color.white);

	
		JPanel jp5 = new JPanel();
		jp5.setLayout(new GridLayout());
		jp5.setPreferredSize(new Dimension(50, 500));
		jp5.setBackground(Color.white);
		JLabel right = new JLabel(new ImageIcon("./images/right.png"));
		jp5.add(right);
		
		container.add(jp1, BorderLayout.NORTH);
		container.add(jp2, BorderLayout.CENTER);
		container.add(jp3, BorderLayout.SOUTH);
		container.add(jp4, BorderLayout.WEST);
		container.add(jp5, BorderLayout.EAST);


		setTitle("도미노 메뉴선택");
		setSize(400,700); 
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //화면상에 안보임
		setVisible(true); //화면상에 구현	
		
	}	
	
}
