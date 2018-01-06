package ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import student.Student;
import students.Students;

public class Delete extends JFrame implements ActionListener{
	Students list;
	Student stu;
	JButton enter;
	JButton delete;
	JPanel panel;
	JDialog dialog;
	GradeTable table;
	JLabel lable;
	TipDialog tip;
	JTextField text;
	public Delete() {
		enter = new JButton("确定");
		delete = new JButton("确认删除");
		text = new JTextField(20);
		lable = new JLabel("请输入要删除学生的编号或者姓名，系统将自动识别");
		lable.setHorizontalAlignment(SwingConstants.CENTER);
		panel = new JPanel();
		//panel.add(lable);
		panel.add(text);
		enter.addActionListener(this);
		this.setLayout(new BorderLayout());
		this.add(lable, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(enter, BorderLayout.SOUTH);
		this.setSize(400,160);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
	public boolean is_digit(String content) {
		 String pattern = "^\\d+";
		 boolean isMatch = Pattern.matches(pattern, content);
		 return isMatch;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == enter){
			String t = text.getText();
			if(is_digit(t)) {//判断输入类型
				//System.out.println("是数字");
				stu = list.query_by_id(Integer.parseInt(t));
			} else {
				//System.out.println("是人名");
				stu = list.query_by_name(t);
			}
			//
			if(stu != null) {
				JPanel content = new JPanel();
				table = new GradeTable();
				table.setVisible(true);
				content.add(delete);
				table.add(content, BorderLayout.SOUTH);
				table.add_row(stu); 
				delete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Students.list.remove(stu);
						table.dispose();
						tip = new TipDialog("删除成功");
					}
				});
				this.dispose();
			} else {
				System.out.println("查找失败，学生不存在");
				new TipDialog("查找失败，学生不存在");
			}
		}
	}
	
}
