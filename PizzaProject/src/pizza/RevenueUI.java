package pizza;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class RevenueUI extends JFrame{
	Admin admin1 = new Admin("admin","admin");
	AdminDAO info = new AdminDAO();

	RevenueUI(){		
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		
		JLabel label1 = new JLabel("매출표");		
		String[] colHeads = {"시간", "피자", "매출액"};		
		Object[][] data = new Object[6][3]; 
		
		
		for(int i=0;i<6;i++) {
			data[i] = admin1.RevenueData(info, i+1);

		}
			
			JTable table1 = new JTable(data,colHeads);
			JScrollPane jsp = new JScrollPane(table1);
			
			container.add(label1, BorderLayout.NORTH);
			container.add(jsp, BorderLayout.CENTER);
			
			setTitle("매출 현황");
			setSize(600,400);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		
	}				
}
