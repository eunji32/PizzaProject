package pizza;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


class JButtonUI extends JFrame implements ActionListener{
	JButton button1;
	JButton button2;
	
	JButtonUI(){
		this.getContentPane().setBackground(Color.white); // 프레임 배경색 지정
		Container container = getContentPane();
		container.setLayout(null);
		
		
		button1 = new JButton("매출 관리");
		button1.setBounds(101, 151,200,100);
		 button1.addActionListener(this);

		
		button2 = new JButton("주문 관리");
		button2.setBounds(101, 401,200,100);
		 button2.addActionListener(this);


		
		container.add(button1);
		container.add(button2);
		
		setTitle("관리자 화면");
		setSize(400,700); 
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String index = e.getActionCommand();
		if(index.equals("매출 관리")) {
			new RevenueUI();
			this.dispose();
		}else if(index.equals("주문 관리")) {
			new OrderCheckUI();
			this.dispose();
		}

	}
}


public class AdminUI {

	public static void main(String[] args) {
		JButtonUI start = new JButtonUI();
	}

}
