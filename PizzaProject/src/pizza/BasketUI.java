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
   ButtonGroup bg;

   JLabel jtf;
   JTextArea sidechoice;
   TextField pcount;
   JButton minus;
   JButton plus;
   int count = 1;
   JTextArea sizechoice;
   JLabel pname;
   JTextArea tesTextArea;
   JButton backButton;
   TextField ppcount;
   private Integer one;
   JComboBox<Object> sidemenu;

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
         ppc.pzList.get(ppc.choice).setSize("Medium");
         JRadioButton sizeM = new JRadioButton(pizzasize + "사이즈" + ":: 0원");
      
      // 라지 사이즈
         int largeprice = 5900;//라지 추가시 요금
        
         ppc.pzList.get(ppc.choice).setSize("Large");
         	//pizzasize setsize	로 인해 변수 초기화
         pizzasize = ppc.PickPizzaInfo().getSize();
         pizzaprice = ppc.PickPizzaInfo().getPrice();
         
         System.out.println(ppc.PickPizzaInfo().getSize());
         ppc.pzList.get(ppc.choice).setPrice(pizzaprice+largeprice);
         JRadioButton sizeL = new JRadioButton(pizzasize+ "사이즈"+":: "+largeprice +"원");

//         System.out.println(pizzaprice);
      bg.add(sizeM); 
      bg.add(sizeL);
      sizeM.setBounds(197, 170, 100, 16);
      sizeL.setBounds(197, 200, 100, 16);
      container.add(sizeM);
      container.add(sizeL);
      
   
      
      //사이드메뉴
      sidemenu = new JComboBox<Object>();
      sdList = new SideMenuControll();
      int choice = 0;
      for (choice =0;choice <7;choice++) {
    	  sidemenu.addItem(sdList.PickSideInfo(choice).getName()
        		  +"추가 :: "+ sdList.PickSideInfo(choice).getPrice() + "원");
	}
      container.add(sidemenu);
      sidemenu.setBounds(42, 280, 320, 30);
      sidemenu.addActionListener(this);
      
      //최종선택
      JLabel pname= new JLabel(pizzaname );
      pname.setBounds(30,380, 200, 30);
      container.add(pname);
      
      /*
      ppcount = new TextField("" + pcount);
      ppcount.setBounds(100,400,200, 30);
      container.add(ppcount);
      */
      
      //선택 사이즈 출력
      sizechoice = new JTextArea(55,30);
      container.add(sizechoice);
      sizechoice.setBounds(30, 410, 55, 30);
      sizeM.addActionListener(this);

      sizeL.addActionListener(this);
      
      
      //선택 사이드메뉴 출력
      sidechoice = new JTextArea(200,100);
      sidechoice.setBounds(30, 440, 200, 80);
      container.add(sidechoice);

      
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
      backButton = new JButton(new ImageIcon("./images/before.png"));
      backButton.setBounds(0,630,200,50);
      backButton.setBorderPainted(false);
      backButton.setContentAreaFilled(false);
      backButton.setFocusPainted(false);
      backButton.setOpaque(false);
      backButton.addMouseListener(this);
      container.add(backButton);

   
      //다음 단계
      nextb = new JButton(new ImageIcon("./images/next.png"));
      nextb.setBounds(200, 630, 200, 50);
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
   /*   
public void paint(Graphics g) {
      g.drawImage(background, 0, 0, null);
   }
*/

@Override
public void actionPerformed(ActionEvent e) {

   //수량 변경
   if(e.getSource().equals(plus)) { 
        pcount.setText("" + ++count);
      }else if(e.getSource().equals(minus)) {
        if(count <= 0) {
           return;
        }
        else {
           pcount.setText("" + --count);
      }
      }


//사이즈선택
//   if(e.getSource().equals(__)) {
//      System.out.println("실행");
   
//   }
   
   
   // 이부분 아주 엉망임 -> 콤보박스에 문구 안나옴
//   sizechoice.append(e.getActionCommand());   
   

//사이드메뉴 선택   
   if(e.getSource().equals(sidemenu)) {
      System.out.println("실행");
      String com = sidemenu.getSelectedItem().toString();
      sidechoice.append(com +"\n");
   }
   
   
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

//public void itemStateChanged(ItemEvent e) {
//   String item = (String)e.getItem(); 
//   sidechoice.setText(item + "\n"); 
//   
//   
//   
//}


@Override
public void mouseClicked(MouseEvent e) {
   // TODO Auto-generated method stub
   if (e.getSource() ==backButton) {
      this.dispose();
      new PizzaPickUI();
   }
   else if (e.getSource() == nextb) {
	   this.dispose();
	   new payUI(ppc, pui, bc);
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



   