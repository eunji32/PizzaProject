package pizza;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class payUI extends JFrame implements ActionListener,MouseListener{
	BorderLayout border = new BorderLayout();
	JButton button1, button2;
	JTextField name_t, number_t, address_t;
	JTextArea jta; 
	
	//확인창
	JLabel receiveName;
	JLabel receiveNum;
	JLabel receiveAddress;
	
	//카드
	JRadioButton card;
	JRadioButton cash;
	JLabel howPay;
	
	
	BasketUI basketUI;
	PizzaPickUI pizzaPickUI;
	
	PizzaPickControl ppc;
	BasketControl bc;
	Icon pui;
	int resultPrice;

	payUI(PizzaPickControl ppc,Icon pui,BasketControl bc, int resultPrice){
		this.ppc = ppc;
		this.pui = pui;
		this.bc = bc;
		this.resultPrice = resultPrice;
		

		
		// 프레임 배경	
		this.getContentPane().setBackground(Color.white); 
		Container container = getContentPane();
		container.setLayout(null);
		
		// 이미지
		ImageIcon icon1 = new ImageIcon("./images/paylogo.jpg");		
		ImageIcon icon2 = new ImageIcon("./images/title1.jpg");			
		ImageIcon in1 = new ImageIcon("./images/input1.jpg");		
		ImageIcon in2 = new ImageIcon("./images/input2.jpg");		
		ImageIcon in3 = new ImageIcon("./images/input3.jpg");		
		ImageIcon icon3 = new ImageIcon("./images/title2.jpg");				
//		ImageIcon icon4 = new ImageIcon("./images/payicon.jpg");		
		ImageIcon icon5 = new ImageIcon("./images/info.jpg");			
		ImageIcon before = new ImageIcon("./images/before.png");			
		ImageIcon next = new ImageIcon("./images/next.png");			
	
		ImageIcon i1 = new ImageIcon("./images/card.jpg");		
		ImageIcon i2 = new ImageIcon("./images/cash.jpg");		
		
		
		// 라벨
		JLabel paylogo = new JLabel(icon1); //로고
		paylogo.setBounds(100,10,icon1.getIconWidth(),icon1.getIconHeight());
		JLabel title1 = new JLabel(icon2); // 주문자
		title1.setBounds(7,100,icon2.getIconWidth(),icon2.getIconHeight());
		JLabel title2 = new JLabel(icon3); // 결제
		title2.setBounds(7,250,icon3.getIconWidth(),icon3.getIconHeight());
		
		JLabel input1 = new JLabel(in1); // 수령자
		input1.setBounds(7,138,in1.getIconWidth(),in1.getIconHeight());
		JLabel input2 = new JLabel(in2); //연락처
		input2.setBounds(7,172,in2.getIconWidth(),in2.getIconHeight());
		JLabel input3 = new JLabel(in3); //배송지
		input3.setBounds(7,206,in3.getIconWidth(),in3.getIconHeight());
		
		// 텍스트
		name_t = new JTextField(10); 
		name_t.setBounds(119,138,270,20);; // 텍스트상자 크기(x,y,가로,세로)
		name_t.setBorder(null); // 텍스트 테두리x
		
		number_t = new JTextField(10); 
		number_t.setBounds(119,172,270,20);;
		number_t.setBorder(null);
		
		address_t = new JTextField(10); 
		address_t.setBounds(119,206,270,20);;
		address_t.setBorder(null);

		// 결제 선택 - 라디오버튼
		JPanel paymain = new JPanel(); 
		paymain.setBounds(7, 290,380,150);
		paymain.setLayout(new GridLayout(1,2));

		
		ButtonGroup bg = new ButtonGroup();
		card = new JRadioButton("신용카드",i1);
		cash = new JRadioButton("현금결제",i2);
		bg.add(card);
		bg.add(cash);
		
		//확인창
		JLabel info = new JLabel(icon5); //배송지
		info.setBounds(7,460,icon5.getIconWidth(),icon5.getIconHeight());
		jta = new JTextArea(5,20);
		jta.setBounds(119, 460, icon5.getIconWidth(),icon5.getIconHeight());
		
		//확인창 이름
		receiveName = new JLabel();
		receiveName.setBounds(119, 470, 200,20);
		receiveName.setFont(new Font("맑은 돋움", Font.BOLD, 16));
		
		//확인창 넘버
		receiveNum = new JLabel();
		receiveNum.setBounds(119, 495, 200, 20);
		receiveNum.setFont(new Font("맑은 돋움", Font.BOLD, 16));
		
		//확인창 주소
		receiveAddress = new JLabel();
		receiveAddress.setBounds(119, 520, 200, 20);
		receiveAddress.setFont(new Font("맑은 돋움", Font.BOLD, 16));
		
		//결제방법
		howPay = new JLabel();
		howPay.setBounds(119, 545, 200, 20);
		howPay.setFont(new Font("맑은 돋움", Font.BOLD, 16));
		
		// 확인창 이벤트 
		name_t.addActionListener(this); 
		number_t.addActionListener(this);
		address_t.addActionListener(this);
		card.addActionListener(this);
		cash.addActionListener(this);
		
		//결제버튼
//		button = new JButton(icon4);
//		button.setBounds(17,580,icon4.getIconWidth(),icon4.getIconHeight());
//		button.setBorderPainted(false);
		
		button1 = new JButton(before);
		button1.setBounds(0,620,before.getIconWidth(),before.getIconHeight());
		button1.setBorderPainted(false);
		button1.addMouseListener(this);
		
		button2 = new JButton(next);
		button2.setBounds(200,620,next.getIconWidth(),next.getIconHeight());
		button2.setBorderPainted(false);
		button2.addMouseListener(this);
		
		
		// 프레임 장착
		container.add(receiveName);
		container.add(receiveNum);
		container.add(receiveAddress);
		container.add(howPay);
		container.add(paylogo);
		container.add(title1);
		container.add(title2);
		container.add(input1);
		container.add(input2);
		container.add(input3);
//		container.add(button);
		container.add(button1);
		container.add(button2);
		container.add(name_t);
		container.add(number_t);
		container.add(address_t);
		container.add(paymain);
		paymain.add(card,BorderLayout.CENTER);
		paymain.add(cash,BorderLayout.CENTER);
		container.add(info);
		container.add(jta);
		
		// 컨테이너 
		setTitle("도미노 피자");
		setSize(400,700); 
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == name_t) {
//			number_t.requestFocus();
//		}else if(e.getSource() == number_t) {
//			address_t.requestFocus();
//		}
//		jta.append(e.getActionCommand()+"\n");	
		if(e.getSource().equals(card) || e.getSource().equals(cash)) {
			receiveName.setText(name_t.getText());
			receiveNum.setText(number_t.getText());
			receiveAddress.setText(address_t.getText());
			if(e.getSource() == card) {
				howPay.setText("신용 카드");
			}else {
				howPay.setText("현금 결제");
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			this.dispose();
			new BasketUI(ppc, pui);
		}
		else if (e.getSource() == button2) {
			this.dispose();
			new LastUI();
//			String addSideName = ;
			bc.PayForBasket(ppc.PickPizzaInfo().getName()
					, receiveAddress.getText(), resultPrice);
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


