package ui;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import run.Run;
import student.Student;
import students.Students;
public class Add extends JFrame{
	Student stu;
	Students list;
	JLabel l;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JTextField t6;
	JTextField t7;
	JPanel p;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	JPanel p5;
	JPanel p6;
	JPanel p7;
	JPanel p8;
	JButton bt;
	Font f;
	public Add() {
		stu = new Student();
		f = new Font("楷体", Font.BOLD, 20);
		l = new JLabel("请输入下列信息");
		l.setFont(f);
		l1 = new JLabel("编号");
		l2 = new JLabel("姓名");
		l3 = new JLabel("年龄");
		l4 = new JLabel("性别");
		l5 = new JLabel("数学成绩");
		l6= new JLabel("计算机成绩");
		l7 = new JLabel("外语成绩");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t7 = new JTextField(20);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		bt = new JButton("确认添加");
		p = new JPanel();
		p.add(l);
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p3.add(l3);
		p3.add(t3);
		p4.add(l4);
		p4.add(t4);
		p5.add(l5);
		p5.add(t5);
		p6.add(l6);
		p6.add(t6);
		p7.add(l7);
		p7.add(t7);
		p8.add(bt);
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					add();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new TipDialog("添加成功");
				dispose();
			}
		});
		//
		this.setLayout(new GridLayout(9, 1));
		this.add(p);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.setTitle("添加学生");
		this.setSize(500, 700);
		this.setLocation(400,200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void add() throws SQLException {
		stu = new Student();
		stu.setId(Integer.parseInt(t1.getText()));
		stu.setName(t2.getText());
		stu.setAge(Integer.parseInt(t3.getText()));
		stu.setSex(t4.getText());
		stu.setMath(Integer.parseInt(t5.getText()));
		stu.setComputer(Integer.parseInt(t6.getText()));
		stu.setFlanguage(Integer.parseInt(t7.getText()));
		stu.cal_ave(stu);
		stu.cal_sum(stu);
		Students.add_stu(stu);
		Run.db.write_student(stu);
		//stu.print_stu_info(stu);//测试
		//System.out.println("人数为"+list.list.size());
	}
	public void set_dispose() {
		this.dispose();
	}
}
