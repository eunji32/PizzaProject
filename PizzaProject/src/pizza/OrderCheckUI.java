	package pizza;

	import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

	
class OrderCheckUI extends JFrame implements ActionListener, MouseListener{
		JLabel label;
		JTable table1;
		int indexi;
		AdminDAO info = new AdminDAO();
		AdminDTO dtoUP = new AdminDTO();
		Object[][] data;

		Admin admin1 = new Admin("admin","admin");
		OrderCheckUI(){
			
			Container container = getContentPane();
			container.setLayout(null);
			
			JButton back = new JButton("돌아가기");
			JButton complete = new JButton("배달 완료");

			JLabel label1 = new JLabel("매출표");		
			String[] colHeads = {"시간", "피자", "배송지","상태"};		
			data = new Object[20][4]; 
			//10에 해당하는 배열에 대해서는 
			//입력되는 전체 데이터 셋의 숫자를 변수로 맞춰주면 됨.
			
			complete.addActionListener(this);
			back.addActionListener(this);
			
			for(int i=0;i<20;i++) {
				data[i] = admin1.OrderData(info, i+1);
			}
				
				table1 = new JTable(data,colHeads);
				JScrollPane jsp = new JScrollPane(table1);
				label1.setBounds(301,10,100,50);
				container.add(label1);
				jsp.setBounds(20,61,650,230);
				container.add(jsp);
				back.setBounds(450,300,100,50);
				container.add(back);
				complete.setBounds(50,300,100,50);
				container.add(complete);
				
				setTitle("매출 현황");
				setSize(700,400);
				setResizable(false);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
				

				 table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 table1.addMouseListener(this);
		 }

	
		
		
//		public void update(int num) {			
//			if(num == indexi) {
//				if(table1.getModel().getValueAt(num, 3).equals("X")) {
//					table1.getModel().setValueAt("O", num, 3);
//					
//					this.dispose();
//					new OrderCheckUI();
//				}
//			}
//		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String index = e.getActionCommand();
			if(index.equals("돌아가기")) {		
				new AdminUI();
				this.dispose();
			}
			if(index.equals("배달 완료")) {	
				this.dispose();
				new yapp(dtoUP);
				
			}
			
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table1.getSelectedRow();
			dtoUP.setindexi(row);
			
			for(int i=0;i<i ;i++) {
				
				if(data[i][3].equals("O")){
					continue;
				}
				System.out.println(data[0][3]);
			}
			
//			if(e.getClickCount()==2) {
//				if(table1.getModel().getValueAt(row, 3).equals("X")) {
//					table1.getModel().setValueAt("O", row, 3);
//					this.dispose();
//					new JbuttonText();
//				}else if(table1.getModel().getValueAt(row, 3).equals("O")) {
//					table1.getModel().setValueAt("X", row, 3);
//					this.dispose();
//					new JbuttonText();
//				}
//			}		

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
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}	
	}
