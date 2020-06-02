package pizza;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class JButtonUI extends JFrame implements ActionListener{
   JButton button1;
   JButton button2;
   JButton button3;
   JLabel domino;
   
   JButtonUI(){
      this.getContentPane().setBackground(Color.white); // 프레임 배경색 지정
      Container container = getContentPane();
      container.setLayout(null);
      
        //상단 로고
        JButton logo = new JButton(new ImageIcon("./images/logo.jpg"));
        logo.setBorderPainted(false);
        logo.setContentAreaFilled(false);
        logo.setBounds(0, 0, 400, 120);
        container.add(logo);
      
      
      button1 = new JButton(new ImageIcon("./images/mg.png"));
      button1.setBounds(51, 180,300,150);
      button1.setBorderPainted(false);
      button1.setContentAreaFilled(false);
      button1.setFocusPainted(false);
      button1.addActionListener(this);

      
      button2 = new JButton(new ImageIcon("./images/jg.png"));
      button2.setBounds(51, 340,300,150);
      button2.setBorderPainted(false);
      button2.setContentAreaFilled(false);
      button2.setFocusPainted(false);
      button2.addActionListener(this);


      domino = new JLabel(new ImageIcon("./images/logo2.png"));
      domino.setBounds(173, 615,50,50);
//      label1.setBorderPainted(false);
//      label1.setContentAreaFilled(false);
//      label1.setFocusPainted(false);
      
      
      container.add(button1);
      container.add(button2);
      container.add(domino);
      
      setTitle("관리자 화면");
      setSize(400,700); 
      setResizable(false);//창의 크기를 변경하지 못하게
      setLocationRelativeTo(null);//창이 가운데 나오게
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);      
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
//      String index = e.getActionCommand();
      if(e.getSource().equals(button1)) {
         new RevenueUI();
         this.dispose();
      }else if(e.getSource().equals(button2)) {
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