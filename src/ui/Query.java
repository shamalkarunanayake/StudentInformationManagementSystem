package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import student.Student;
import students.Students;

public class Query extends JFrame {
	Student stu;
	Students list;
	GradeTable table;
	JButton enter;
	JRadioButton c1;
	JRadioButton c2;
	ButtonGroup group;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JTextField text;
	JLabel title;
	
	public Query() {
		table = new GradeTable();
		title = new JLabel("请输入学生编号");// 提示信息
		text = new JTextField(20);// 查询输入框
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		enter = new JButton("查询");
		c1 = new JRadioButton("按编号查询");
		c2 = new JRadioButton("按姓名查询");
		group = new ButtonGroup();
		c1.setSelected(true);
		group.add(c1);
		group.add(c2);
		panel1.add(title);
		panel2.add(text);
		panel2.add(c1);
		panel2.add(c2);
		panel3.add(enter);
		this.add(panel1, BorderLayout.NORTH);// BorderLayout
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel3, BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setLocation(200, 100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		MyListener l = new MyListener();
		c1.addActionListener(l);
		c2.addActionListener(l);
		enter.addActionListener(l);
	}

	public boolean is_digit(String content) {
		String pattern = "^\\d+";
		boolean isMatch = Pattern.matches(pattern, content);
		return isMatch;
	}

	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean flag = true;
			if (c1.isSelected()) {// 表示按编号查询
				flag = true;
				title.setText("请输入学生编号");
			} else {
				flag = false;
				title.setText("请输入学生姓名");
			}
			if (e.getSource() == enter) {
				String content = text.getText();// 文本框内容
				if (content.equals("")) {// 输入为空
					new TipDialog("输入为空，请重新输入");
				} else {// 输入不为空
					if (flag) {// 根据编号查找
						if (is_digit(content)) {
							dispose();
							stu = list.query_by_id(Integer.parseInt(content));
							if (stu == null) {// 如果学生找不到
								new TipDialog("查找失败，该编号学生不存在");
							} else {
								table.setVisible(true);
								table.add_row(stu);
							}
						} else {
							new TipDialog("请输入数字");
						}
					} else {// 根据姓名查找
						if(!is_digit(content)) {
							dispose();
							stu = list.query_by_name(content);
							if (stu == null) {// 如果学生找不到
								new TipDialog("查找失败，该姓名学生不存在");
							} else {
								table.setVisible(true);
								table.add_row(stu);
							}
						} else {
							new TipDialog("请输入姓名");
						}//else
					} // else
				} // else
			} // if
		}// actionPerformed
	}// class
}
