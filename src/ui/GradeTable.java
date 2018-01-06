package ui;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import student.Student;

public class GradeTable extends JFrame{
	JScrollPane jsp;
	Student stu;
	JTable table;
	DefaultTableModel model;
	Vector colum_data;
	Object[] colum;
	public GradeTable() {
		colum  = new String[]{"编号","姓名","性别","年龄","数学成绩","计算机成绩","外语成绩","总分","平均分"};
		//
		colum_data = new Vector();
		colum_data.add(colum[0]);
		colum_data.add(colum[1]);
		colum_data.add(colum[2]);
		colum_data.add(colum[3]);
		colum_data.add(colum[4]);
		colum_data.add(colum[5]);
		colum_data.add(colum[6]);
		colum_data.add(colum[7]);
		colum_data.add(colum[8]);
		//
		
		table = new JTable();
		model = new DefaultTableModel(colum_data, 0);
		table.setModel(model);
		jsp = new JScrollPane(table);
		//
		this.setTitle("GradeTable");
		this.setLayout(new BorderLayout());
		this.add(jsp, BorderLayout.CENTER);
		this.setSize(800, 450);
		this.setLocation(200,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
	}
	public void add_row(Student stu) {
		Vector t = new Vector();
		t.add(stu.getId());
		t.add(stu.getName());
		t.add(stu.getSex());
		t.add(stu.getAge());
		t.add(stu.getMath());
		t.add(stu.getComputer());
		t.add(stu.getFlanguage());
		t.add(stu.getSum());
		t.add(stu.getAve());//System.out.println(stu.getAve());
		model.addRow(t);
		table.updateUI();
	}
	public void set_table(Object[][] data) {
		model = new DefaultTableModel(data, colum);
		table.setModel(model);
		table.updateUI();
	}
	public void set_table(Student stu) {
		Vector t = new Vector();
		t.add(stu.getId());
		t.add(stu.getName());
		t.add(stu.getSex());
		t.add(stu.getAge());
		t.add(stu.getMath());
		t.add(stu.getComputer());
		t.add(stu.getFlanguage());
		t.add(stu.getSum());
		t.add(stu.getAve());
		Vector s = new Vector();
		s.add(t);
		model = new DefaultTableModel(s, colum_data);
		table.setModel(model);
		table.updateUI();
	}
}
