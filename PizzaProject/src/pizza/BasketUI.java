package pizza;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class BasketUI extends JFrame implements MouseListener,ActionListener, ItemListener{
   
   Image background;//배경이미지
     
   PizzaPickControl ppc;
   BasketControl bc;
   String pizzaname;
   Icon pui;
   ButtonGroup bg;
   JRadioButton sizeM;
   JRadioButton sizeL;
   JLabel pname;
   JLabel lastPrice;//최종값
   ArrayList<JButton> deleteSide;
   ArrayList<Food> pickSide;

   JLabel jtf;
   ArrayList<JLabel> sidechoice;
   TextField pcount;
   JButton minus;
   JButton plus;
   int count = 1;
   JLabel sizechoice;
   JTextArea tesTextArea;
   JButton backButton;
   TextField ppcount;
   private Integer one;
   int resultPrice;
   JComboBox<Object> sidemenu;
   
   Font f2 = new Font("맑은 돋움", Font.BOLD, 15);
   Font f3 = new Font("맑은 돋움", Font.BOLD, 18);

 SideMenuControll sdList;
 JButton nextb;
   
   BasketUI(PizzaPickControl ppc,Icon pui){
	   
      this.pui =pui;
      this.ppc=ppc;
      bc=new BasketControl(ppc);
      pizzaname =  ppc.PickPizzaInfo().getName();
      int pizzaprice = ppc.PickPizzaInfo().getPrice();
      String pizzasize = ppc.PickPizzaInfo().getSize();
      String pizzaedge = ppc.PickPizzaInfo().getEdge();
      pickSide = new ArrayList<Food>();
      
      resultPrice = pizzaprice;
      
      Container container = getContentPane();   
      
      container.setLayout(null);
      
      //백그라운드 화면
      background=
      new ImageIcon("./images/background.png").getImage();
      
      //상품이미지(불러올 예정)
      JLabel pimage = new JLabel(pui);
      pimage.setBounds(35, 105, 110, 110);
      container.add(pimage);
      
      
      
      //상품명 jTextArea test
      JLabel text= new JLabel(pizzaname);
      text.setBounds(170,105, 200, 30);
      text.addMouseListener(this);
      container.add(text);
      
      
      
      
       // "-" 버튼
       minus = new JButton(new ImageIcon("./images/minus.png"));
       minus.setBounds(200,140, 15, 15);
       container.add(minus);
       minus.addActionListener(this);
 
       
      //수량선택
      pcount = new TextField("" + count);
      pcount.setBackground(Color.white);
      pcount.setEditable(false);
      pcount.setBounds(220,140, 40, 17);
       container.add(pcount);
       pcount.addActionListener(this);

      
       // "+" 버튼
       plus = new JButton(new ImageIcon("./images/plus.png"));
       plus.setBounds(265,140, 15, 15);
       container.add(plus);
       plus.addActionListener(this);
       
       
      //사이즈 선택
         ButtonGroup bg = new ButtonGroup();
         	//미디움 사이즈
         //ppc.pzList.get(ppc.choice).setSize("Medium");
         
      
      // 라지 사이즈
         int largeprice = 5900;//라지 추가시 요금
        
         //ppc.pzList.get(ppc.choice).setSize("Large");
         
         	//pizzasize setsize	로 인해 변수 초기화
        // pizzasize = ppc.PickPizzaInfo().getSize();
        // pizzaprice = ppc.PickPizzaInfo().getPrice();
         
       //  ppc.pzList.get(ppc.choice).setPrice(pizzaprice+largeprice);
         
      sizeM = new JRadioButton("Medium" + ":: 0원");
      sizeL = new JRadioButton("Large"+":: "+largeprice +"원");

//         System.out.println(pizzaprice);
      bg.add(sizeM); 
      bg.add(sizeL);
      sizeM.setBounds(197, 170, 130, 16);
      sizeL.setBounds(197, 200, 130, 16);
      container.add(sizeM);
      container.add(sizeL);
      
      sizeM.addActionListener(this);
      sizeL.addActionListener(this);
      
   
      
      //사이드메뉴
      sidemenu = new JComboBox<Object>();
      sdList = new SideMenuControll();
      int choice = 0;
      for (choice =0;choice < 7;choice++) {
    	  sidemenu.addItem(sdList.PickSideInfo(choice).getName()
        		  +"추가 :: "+ sdList.PickSideInfo(choice).getPrice() + "원");
	}
      container.add(sidemenu);
      sidemenu.setBounds(42, 280, 320, 30);
      sidemenu.addActionListener(this);
      
      //최종선택
      pname = new JLabel(pizzaname);
      pname.setBounds(27,380, 300, 30);
      pname.setFont(f2);
      container.add(pname);
      
      
      //선택 사이즈 출력
      sizechoice = new JLabel("Medium");
      sizechoice.setBounds(27, 400, 120, 30);
      sizechoice.setFont(f2);
      container.add(sizechoice);
      
      //선택 사이드메뉴 출력
      sidechoice = new ArrayList<JLabel>();
      for(int i = 0; i < 3; i++) {
    	  sidechoice.add(new JLabel(""));// 선언
    	  sidechoice.get(i).setBounds(27, 430 + 25 * i, 200, 25);
    	  sidechoice.get(i).setFont(f2);
    	  container.add(sidechoice.get(i));
      }
      
      //사이드 삭제 버튼
      deleteSide = new ArrayList<JButton>();
      for(int i = 0; i < 3; i++) {
    	  deleteSide.add(new JButton(new ImageIcon("./images/minus.png")));
    	  deleteSide.get(i).setBounds(230, 430 + 25 * i, 23, 25); //선언
    	  deleteSide.get(i).setBackground(new Color(0,0,0));
    	  deleteSide.get(i).setOpaque(true);
    	  deleteSide.get(i).setForeground(new Color(255,255,255));
    	  deleteSide.get(i).setVisible(false);
    	  container.add(deleteSide.get(i));
    	  deleteSide.get(i).addActionListener(this);
      }
      

      
      //최종 결제 금액
      lastPrice = new JLabel(Integer.toString(resultPrice), SwingConstants.RIGHT);
      lastPrice.setBounds(240, 543, 130, 50);
      lastPrice.setFont(new Font("맑은 돋움", Font.BOLD, 25));
      lastPrice.setOpaque(true);//글자 변경가능
      lastPrice.setForeground(new Color(255,255,255));
      lastPrice.setBackground(new Color(0,0,0));
      container.add(lastPrice);
      
      //뒤로가기 버튼
      backButton = new JButton(new ImageIcon("./images/before.png"));
      backButton.setBounds(0,620,200,50);
      backButton.setBorderPainted(false);
      backButton.setContentAreaFilled(false);
      backButton.setFocusPainted(false);
      backButton.setOpaque(false);
      backButton.addMouseListener(this);
      container.add(backButton);

   
      //다음 단계
      nextb = new JButton(new ImageIcon("./images/next.png"));
      nextb.setBounds(200, 620, 200, 50);
      nextb.setBorderPainted(false);
       nextb.setContentAreaFilled(false);
       nextb.setFocusPainted(false);
       nextb.setOpaque(false);
       
       container.add(nextb);
       nextb.addMouseListener(this);
      
       JLabel back = new JLabel(new ImageIcon("./images/background.png"));
       back.setBounds(0, 0, 400, 700);
       
       container.add(back);
       
       setTitle("메뉴 상세 페이지");
       setSize(400,700); 
       setResizable(false);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);  
   }


@Override
public void actionPerformed(ActionEvent e) {
	
   //수량 변경
	if(e.getSource().equals(plus)) { 
        pcount.setText("" + ++count);
   	}else if(e.getSource().equals(minus) && count > 0) {
        pcount.setText("" + --count); 
    }
	pname.setText(pizzaname + "  " + pcount.getText() + "개" );
	
   //사이즈 선택
   if(e.getSource().equals(sizeM)) {
	   if(sizechoice.getText() != "Medium") {
		   ppc.PickPizzaInfo().setPrice(
				   ppc.PickPizzaInfo().getPrice() - 5900);
		   sizechoice.setText("Medium");
	   }
   }else if(e.getSource().equals(sizeL)) {
	   if(sizechoice.getText() != "Large") {
		   ppc.PickPizzaInfo().setPrice(
				   ppc.PickPizzaInfo().getPrice() + 5900);
		   sizechoice.setText("Large");
	   }
	   
   }
   
   resultPrice = ppc.PickPizzaInfo().getPrice() * count;

   int choice = 0;
   if(e.getSource().equals(sidemenu)) {
	   for(int i = 0; i < sidechoice.size(); i++) {
		   if(sidechoice.get(i).getText().equals("")) {
			   sidechoice.get(i).setText(sidemenu.getSelectedItem().toString());
			   deleteSide.get(i).setVisible(true);
			   pickSide.add(new SideMenu(sidemenu.getSelectedItem().toString(), 
					   sdList.PickSideInfo(sidemenu.getSelectedIndex()).getPrice()));
			   break;
		   }
	   }
   }

   
   
   //삭제
   for(int i = 0; i < deleteSide.size(); i++) {
	   if(e.getSource().equals(deleteSide.get(i))) {
		   for(int y = 0; y < pickSide.size(); y++) {
			   if(pickSide.get(y).getName().equals(sidechoice.get(i).getText())) {
				   pickSide.remove(y);
				   break;
			   }
		   }
		   sidechoice.get(i).setText("");
		   
		   deleteSide.get(i).setVisible(false);
		   
		   
	   }
   
   
   

   }

   //확인
   for(int i = 0; i < pickSide.size(); i++) {
	   resultPrice += pickSide.get(i).getPrice();
   }
   
   
   //최종머니 출력
   lastPrice.setText(Integer.toString(resultPrice));
   
   
   
}


@Override
public void mouseClicked(MouseEvent e) {
   // TODO Auto-generated method stub
   if (e.getSource() == backButton) {
      this.dispose();
      new PizzaPickUI();
   }
   else if (e.getSource() == nextb) {
	   this.dispose();
	   new payUI(ppc, pui, bc, resultPrice);
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

@Override
public void itemStateChanged(ItemEvent e) {
   // TODO Auto-generated method stub
   
}



}      



   