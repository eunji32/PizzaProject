package pizza;

import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class BasketUI extends JFrame implements MouseListener{
		PizzaPickControl ppc;
		BasketControl bc;
	   
	   BasketUI(PizzaPickControl ppc){
	      this.ppc = ppc;
	      bc = new BasketControl(ppc); //컨트롤러에서도 사용할수있게한다.
	      
	      Container container = getContentPane();
	      
	      //임시 버튼 생성 /나중에 삭제할거
	      JButton na2 = new JButton(ppc.PickPizzaInfo().getName());
	      
	      container.setLayout(new FlowLayout());
	      
	      //임시 버튼 실행
	      container.add(na2);
	      na2.addMouseListener(this);
	      
	      setTitle("주문내역 확인");
	      setSize(400,700); 
	      setResizable(false);//창의 크기를 변경하지 못하게
	      setLocationRelativeTo(null);//창이 가운데 나오게
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);   
	   }

	   public void mouseClicked(MouseEvent e) {
		   //마지막에 버튼 클릭 시 해야하는 동작
		   new LastUI();
		   this.dispose();
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
