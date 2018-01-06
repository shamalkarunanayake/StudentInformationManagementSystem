package run;

import db.db1;
import ui.LogIn;
public class Run {
	public static boolean  flag = false;
	public static db1 db;
	public static void main(String argc[]) throws Exception {
		//Students list = new Students();
//		Student s1 = new Student(12, "李四", 23, "男", 67, 78, 89);
//		s1.cal_ave(s1);
//		Student s2 = new Student(24, "张三", 19, "女", 67, 78, 89);
//		s2.cal_ave(s2);
//		Students.list.add(s1);
//		Students.list.add(s2);
		//new Add();
		//new Delete();
		//new Alter();
		
		db = new db1();
		try {
			db.get_db_info();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogIn in = new LogIn();
//		System.out.println(flag);
//		System.out.println(flag);
		//new ui.Query();
		//new MainInterface();
		//new TipDialog("你好啊").setVisible(true);
		
	}
}
