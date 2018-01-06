package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import student.Student;
import students.Students;


public class MainInterface extends JFrame {
	Student stu;
	Students list = new Students();
	Button bt1 = new Button("添加");
	Button bt2 = new Button("查询");
	Button bt3 = new Button("修改");
	Button bt4 = new Button("删除");
	Button bt5 = new Button("退出程序");
	//
	JPanel panle_south = new JPanel();// 功能区
	PicPanel panle_north = new PicPanel("src/pic/01.jpg");// 图片区
	JPanel students = new JPanel();// 显示多个学生信息面板
	//
	JDialog query = new JDialog();// 查询结果对话框

	public MainInterface() {
		//
		// panle_north.add(new JLabel("此处放图片"));
		panle_south.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		panle_south.add(bt1);
		panle_south.add(bt2);
		panle_south.add(bt3);
		panle_south.add(bt4);
		panle_south.add(bt5);
		//
		MyListener l = new MyListener();
		bt1.addActionListener(l);
		bt2.addActionListener(l);
		bt3.addActionListener(l);
		bt4.addActionListener(l);
		bt5.addActionListener(l);
		//
		this.setLayout(new BorderLayout());
		this.add(panle_north, BorderLayout.CENTER);
		this.add(panle_south, BorderLayout.SOUTH);
		this.setTitle("学生信息管理系统");
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch (cmd) {
			case "添加":
				new Add();
				System.out.println(cmd);
				break;
			case "查询":
				new Query();
				System.out.println(cmd);
				break;
			case "修改":
				new Alter();
				System.out.println(cmd);
				break;
			case "删除":
				Delete delete = new Delete();
				System.out.println(cmd);
				break;
			case "退出程序":
			
				System.exit(0);
				System.out.println(cmd);
				break;
			}
			
		}
	}
}
