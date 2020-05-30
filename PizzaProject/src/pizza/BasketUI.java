package pizza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

class BasketUI extends JFrame implements MouseListener,ActionListener, ItemListener{
   
	Image background;//배경이미지
	  
	PizzaPickControl ppc;
	BasketControl bc;
	String pizzaname;
	Icon pui;
	
	JLabel sizechoice;
	JLabel jtf;
	JLabel sidechoice;
	TextField pcount;
	JButton minus;
	JButton plus;
	int count = 1;
	JTextArea finalorder;
	JLabel pname;
	JTextArea tesTextArea;
	JButton backButton;

	private Integer one;
	
	
	BasketUI(PizzaPickControl ppc,Icon pui){
	   this.pui =pui;
	   this.ppc=ppc;
	   bc=new BasketControl(ppc);
	   pizzaname =  ppc.PickPizzaInfo().getName();
	   
	   Container container = getContentPane();   
	   
	   container.setLayout(null);
	   
	   //백그라운드 화면
	   background=
	   new ImageIcon("./images/background.png").getImage();
	   
	   //상품이미지(불러올 예정)
	   JButton pimage = new JButton(pui);
	   pimage.setBounds(45, 90, 100, 100);
	   container.add(pimage);
	   
	   
	   
	   //상품명 jTextArea test
	   TextField text= new TextField(pizzaname);
	   text.setBounds(170,80, 150, 30);
	   text.addMouseListener(this);
	   text.setEditable(false);
	   container.add(text);
	   
	   //상품명 (불러오기)
//	   pname = new JLabel(pizzaname);
//
//	   pname.setVisible(true);
//	   pname.setOpaque(true);
////	   pname.setFont(new Font("Verdana", Font.PLAIN, 15));
////	   pname.setText(pizzaname);
//	   pname.addMouseListener(this);//위치 찾으려구 ..
//	   pname.setBounds(170,80, 150, 30);
//	  
//	   container.add(pname);

	   
       // "-" 버튼
       JButton minus = new JButton(new ImageIcon("./images/minus.png"));
       minus.setBounds(200,117, 15, 15);
       container.add(minus);
       minus.addActionListener(this);
 
       
	   //수량선택
	   TextField pcount = new TextField("" + count);
	   pcount.setBackground(Color.white);
	   pcount.setEditable(false);
	   pcount.setBounds(220,115, 30, 20);
       container.add(pcount);
       pcount.addActionListener(this);

      
       // "+" 버튼
       JButton plus = new JButton(new ImageIcon("./images/plus.png"));
       plus.setBounds(260,117, 15, 15);
       container.add(plus);
       plus.addActionListener(this);
       
	   
	   //사이즈 선택
	   	ButtonGroup bg = new ButtonGroup();
		JRadioButton sizeM = new JRadioButton("M금액호출");
		JRadioButton sizeL = new JRadioButton("L금액호출");
		bg.add(sizeM); 
		bg.add(sizeL);
		sizeM.setBounds(197, 149, 100, 16);
		sizeL.setBounds(197, 177, 100, 16);
		container.add(sizeM);
		container.add(sizeL);
		
		//음료 선택
		JCheckBox jcb1 = new JCheckBox("콜라 추가");
		jcb1.setBounds(40, 275, 100, 30);
		JCheckBox jcb2 = new JCheckBox("피클 추가");
		jcb2.setBounds(150, 275, 100, 30);
		JCheckBox jcb3 = new JCheckBox("소스 추가");
		jcb3.setBounds(250, 275, 100, 30);
	
		container.add(jcb1);
		container.add(jcb2);
		container.add(jcb3);		
	   
	   
	   //사이드메뉴
		JComboBox<Object> sidemenu = new JComboBox<Object>();
		one = 0;
		sidemenu.addItem("추가 안함 :: "+one + "원");
		one = 1500;
		sidemenu.addItem("샐러드 추가 :: "+one + "원");
		one = 1500;
		sidemenu.addItem("치킨윙 추가 :: "+one + "원");
		one = 1500;
		sidemenu.addItem("스파게티 추가 :: "+one + "원");
		one = 3000;
		sidemenu.addItem("치즈볼 추가 :: "+one + "원");
		sidemenu.setBounds(42, 340, 300, 30);
		container.add(sidemenu);
		sidemenu.addItemListener(this);

		
		
	   //최종선택
		
		
		finalorder = new JTextArea(7,20);
		container.add(finalorder);
		finalorder.setBounds(20, 400, 150, 30);
		sizeM.addActionListener(this);
		sizeL.addActionListener(this);
		sidemenu.addItemListener(this);
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		
		/*
		sizechoice = new JLabel("");
		sizechoice.setBounds(20, 400, 150, 30);
		container.add(sizechoice);
		sizeM.addActionListener(this);
		sizeL.addActionListener(this);
		
		
		sidechoice = new JLabel("");
		sidechoice.setBounds(170, 400, 150, 30);
		container.add(sidechoice);
		sidemenu.addItemListener(this);
		
	
		
		jtf = new JLabel("");
		jtf.setBounds(170, 500, 150, 30);
		container.add(jtf);
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);
		jcb3.addItemListener(this);
		*/
		
	   //최종 결제 금액
		
		//뒤로가기 버튼
		backButton = new JButton();
		backButton.setBounds(0,0,80,30);
		backButton.setText("BACK");
		backButton.addMouseListener(this);
		container.add(backButton);
	
	   //다음 단계
	   JButton nextb = new JButton(new ImageIcon("./images/next.png"));
	   nextb.setBounds(100, 635, 200, 30);
	   nextb.setBorderPainted(false);
       nextb.setContentAreaFilled(false);
       nextb.setFocusPainted(false);
       nextb.setOpaque(false);
       
       container.add(nextb);
	   

	    setTitle("메뉴 상세 페이지");
	    setSize(400,700); 
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);  
   }
	   
public void paint(Graphics g) {
	   g.drawImage(background, 0, 0, null);
   }


@Override
public void actionPerformed(ActionEvent e) {
	finalorder.setText(e.getActionCommand());
	
}

/*

public void actionPerformed(ActionEvent e) {
	
	if (e.getSource() == plus) {
		count++; 
		pcount.setText(count + "");
	} else if (e.getSource() == minus) {
		count--; 
		pcount.setText(count + ""); 
	} else {
		count = 0;
		pcount.setText(count + ""); 
		} 
	}

*/

public void itemStateChanged(ItemEvent e) {
	if (e.getItem() instanceof String) {
	
	String item = (String)e.getItem()+ "\n"; 
	finalorder.setText(item); 
	
	} else if (e.getItem() instanceof JCheckBox) {
		JCheckBox selectCB =(JCheckBox)e.getItem();  
		finalorder.setText(selectCB.getText()+ "\n"); 
	}
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() ==backButton) {
		this.dispose();
		new PizzaPickUI();
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



	