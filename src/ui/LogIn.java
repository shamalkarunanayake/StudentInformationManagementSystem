package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame{
	Image img; 
	JTextField name;
	JPasswordField password;
	JLabel l1 = new JLabel("账号");
	JLabel l2 = new JLabel("密码");
	JButton enter;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	MyPanel p4;
	public LogIn() {
		//
		enter = new JButton("登录");
		enter.setBackground(Color.ORANGE);
		name = new JTextField(30);
		password = new JPasswordField(30);
		p1 = new StringPanel("学生信息管理系统");
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new MyPanel();
	    p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.add(l1);
		p2.add(name);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(l2);
		p3.add(password);
		p4.add(enter);
		//
		this.setLayout(new GridLayout(4, 1));
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.setTitle("登录");
		this.setSize(500,300);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = name.getText();
				String user_password = String.valueOf(password.getPassword());
				if(check(user_name, user_password)) {
					MainInterface main = new MainInterface();//打开主界面
					set_dispose();//关闭登陆界面
				} else {
					new TipDialog("账号或密码错误，登录失败");
				}
				
			}
		});
		Thread t =new Thread(p4); 
		t.start(); 
	}
	public void set_dispose() {
		this.dispose();
	}
	
	private boolean check(String name, String password) {
		if(name.equals("1")&& password.equals("1")) {
			return true;
		}
		return false;
	}
	
}
