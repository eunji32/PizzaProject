package pizza;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ManagerLogin extends JFrame implements ActionListener{
	String id = null;
	String passwd = null;
	Font f1 = new Font("맑은 돋움", Font.BOLD, 18);
	JButton loginBu;
	JTextField idField;
	JPasswordField passField;
	JButton backButton;
	JTextArea wrongLogin;
	
	
	int width = 400;
	int height = 700;
	
	ManagerLogin(){
		JPanel upPan = new JPanel();
		upPan.setLayout(null);
		upPan.setBounds(0, 0, width, height / 2);
		upPan.setBackground(Color.white);
		
		
		JLabel explainLogin = new JLabel("관리자 로그인");
		idField = new JTextField("");
		passField = new JPasswordField();
		backButton = new JButton(new ImageIcon("./images/backicon.jpg"));
		wrongLogin = new JTextArea();
		
		
		//글꼴
		//idText.setFont(f1);
		//passText.setFont(f1);
		idField.setFont(f1);
		passField.setFont(f1);
		wrongLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		explainLogin.setFont(new Font("맑은 돋움", Font.BOLD, 30));
		
		//배치
		//idText.setBounds(50, 150, 150, 20);
		//passText.setBounds(50, 200, 150, 20);
		explainLogin.setBounds(width / 2 - 100, 20, 200, 100);
		idField.setBounds(width/2 - 140, 130, 280, 50);
		passField.setBounds(width/2 - 140, 200, 280, 50);
		backButton.setBounds(350, 610, 30, 30);
		backButton.setBorderPainted(false);
		wrongLogin.setBounds(82, 450, 280, 150);
//		passField.setEchoChar("*");
		
		idField.getActionListeners();
		passField.getActionListeners();
		backButton.addActionListener(this);
		
		//입력
		//upPan.add(idText);
		//upPan.add(passText);
		upPan.add(explainLogin);
		upPan.add(idField);
		upPan.add(passField);
		
		loginBu = new JButton("로 그 인");
		loginBu.setBounds(width / 2 - 140, 280, 280, 80);
		loginBu.setFont(new Font("맑은 돋움", Font.BOLD, 25));
		loginBu.setBackground(new Color(0, 204, 51));
		loginBu.setOpaque(true);
		loginBu.setForeground(new Color(255, 255, 255));
		loginBu.addActionListener(this);
		
		
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(new Color(255, 255, 255));
		
		container.add(loginBu);
		container.add(upPan);
		container.add(backButton);
		container.add(wrongLogin);
		
		
		
		setTitle("관리자로그인");
		setSize(400,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		id = idField.getText();
		passwd = passField.getText();
		if(id.equals("admin")) {
			if(passwd.equals("adminuser")) {
				wrongLogin.setText("로그인 성공");
				this.dispose();
				new AdminUI();
			}else {
				wrongLogin.setText("로그인에 실패하셨습니다 \n계속 틀릴 경우 관리자에게 \n 문의해주시기 바랍니다.");
			}
		}else {
			wrongLogin.setText("로그인에 실패하셨습니다 \n계속 틀릴 경우 관리자에게 \n 문의해주시기 바랍니다.");
		}
		
		if(e.getSource().equals(backButton)) {
			this.dispose();
			new FirstUI();
		}
	}
}
