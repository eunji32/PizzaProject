package pizza;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class yapp extends JFrame implements ActionListener{
	AdminDAO info = new AdminDAO();
	AdminDTO dto = new AdminDTO();
	JLabel ques = new JLabel("선택한 셀을 변경하시겠습니까?");
	JButton yap = new JButton("예");
	JButton nop = new JButton("아니오");
	OrderCheckUI callindex = new OrderCheckUI();
	int C ;
	
	yapp(AdminDTO dto){
		this.dto = dto;
		Container container = getContentPane();
		container.setLayout(null);
		yap.setBounds(51, 111, 80, 30);
		nop.setBounds(171, 111, 80, 30);
		ques.setBounds(61, 50, 200, 40);
		container.add(yap);
		container.add(nop);
		container.add(ques);
		C =dto.getindexi();


		yap.addActionListener(this);
		nop.addActionListener(this);

		
		setTitle("매출 현황");
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String index = e.getActionCommand();
		if(index.equals("예")) {
			this.dispose();
			info.update(dto, C);
			
//			callindex.dispose();
			new OrderCheckUI();
		
			
		}else if(index.equals("아니오")) {			
			this.dispose();
		}
	}
}