package pizza;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class BasketUI extends JFrame{
		PizzaPickControl ppc;
		BasketControl bc;
	   
	   BasketUI(PizzaPickControl ppc){
	      this.ppc = ppc;
	      bc = new BasketControl(ppc); //컨트롤러에서도 사용할수있게한다.
	      
	      Container container = getContentPane();
	      JLabel na = new JLabel(ppc.PickPizzaInfo().getName());
	      
	      container.setLayout(new FlowLayout());
	      
	      container.add(na);
	      
	      
	      setTitle("도미노 피자 메인");
	      setSize(400,700); 
	      setResizable(false);//창의 크기를 변경하지 못하게
	      setLocationRelativeTo(null);//창이 가운데 나오게
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);   
	   }
	
	
}
