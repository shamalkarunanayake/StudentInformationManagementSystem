package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import student.Student;
import students.Students;

public class Alter {
	Students list;
	Student stu;
	JPanel panel;
	JComboBox box;
	//GradeTable table;
	JTextField alter_text;
	JLabel lable;
	Query query;
	JFrame j;
	JPanel p;
	JPanel bt_panel;
	JButton alter;
	JButton close;
	JButton finish;
	JButton enter;
	public Alter() {
		alter = new JButton("进行修改");
		close = new JButton("修改结束");
		p = new JPanel();
		p.add(alter);
		p.add(close);
		query = new Query();
		query.table.add(p, BorderLayout.SOUTH);
		alter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Alter();
				stu = new Student();
				stu = query.stu;
			}
		});
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				query.table.dispose();
			}
		});//ok
	}

	public void Alter() {
		j = new JFrame("修改");
		bt_panel = new JPanel();
		panel = new JPanel();
		box = new JComboBox();
		alter_text = new JTextField(20);
		enter = new JButton("确认修改");
		finish = new JButton("完成修改");
		lable = new JLabel("请在文本框输入新的信息");
		box.addItem("请选择修改的信息");
		box.addItem("姓名");
		box.addItem("年龄");
		box.addItem("性别");
		box.addItem("数学分数");
		box.addItem("计算机分数");
		box.addItem("外语分数");
		panel.add(box);
		panel.add(alter_text);
		bt_panel.add(enter);
		bt_panel.add(finish);
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		// text.setText("输入新的信息");
		//
		j.setLayout(new BorderLayout());
		j.add(lable, BorderLayout.NORTH);
		j.add(panel, BorderLayout.CENTER);
		j.add(bt_panel, BorderLayout.SOUTH);
		j.setSize(300, 160);
		j.setLocation(200, 400);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//
		j.setVisible(true);
		//
		box.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = (String)box.getSelectedItem();
				if(item.equals("请选择修改的信息")) {
					alter_text.setEditable(false);
				} else {
					alter_text.setEditable(true);
				}
			}
		});//box
		
		enter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				String item = (String)box.getSelectedItem();
				String content = alter_text.getText();
				if(!content.equals("")) {
					switch(item) {
					case"请选择修改的信息":
						flag = false;
						new TipDialog("请选择要修改的学生信息");
						break;
					case"姓名":
						stu.setName(content);
						break;
					case"年龄":
						stu.setAge(Integer.parseInt(content));
						break;
					case"性别":
						stu.setSex(content);
						break;
					case"数学分数":
						stu.setMath(Integer.parseInt(content));
						break;
					case"计算机分数":
						stu.setComputer(Integer.parseInt(content));
						break;
					case"外语分数":
						stu.setFlanguage(Integer.parseInt(content));
						break;
					}
					if(flag)
						query.table.set_table(stu);
				} else {
					new TipDialog("输入为空");
				}
				
			}//actionPerformed
		});//enter.addActionListener
		finish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				j.dispose();
			}
		});
	}//Alter
}
