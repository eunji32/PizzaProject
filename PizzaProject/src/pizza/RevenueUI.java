package pizza;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class RevenueUI extends JFrame implements ActionListener{
	Admin admin1 = new Admin("admin","admin");
	AdminDAO info = new AdminDAO();

	RevenueUI(){		
		
		Container container = getContentPane();
		container.setLayout(null);
		
		JButton back = new JButton("돌아가기");
		JLabel label1 = new JLabel("매출표");		
		String[] colHeads = {"시간", "피자", "매출액"};		
		Object[][] data = new Object[20][3]; 
		//10에 해당하는 배열에 대해서는 
		//입력되는 전체 데이터 셋의 숫자를 변수로 맞춰주면 됨.
		
		back.addActionListener(this);
		
		for(int i=0;i<5;i++) {
			data[i] = admin1.RevenueData(info, i+1);

		}
			
			JTable table1 = new JTable(data,colHeads);
			JScrollPane jsp = new JScrollPane(table1);
			label1.setBounds(301,10,100,50);
			container.add(label1);
			jsp.setBounds(20,61,560,230);
			container.add(jsp);
			back.setBounds(450,300,100,50);
			container.add(back);
			
			setTitle("매출 현황");
			setSize(600,400);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String index = e.getActionCommand();
		if(index.equals("돌아가기")) {
			new JButtonUI();
			this.dispose();
		}
	}
	
}
