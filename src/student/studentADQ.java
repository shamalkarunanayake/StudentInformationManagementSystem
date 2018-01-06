package student;

import java.util.Scanner;

public class studentADQ {
	int id;
	String name;
	String sex;
	int age;
	int math;
	int computer;
	int Flanguage;
	// add
	Scanner in = new Scanner(System.in);

	public Boolean add() {
		Student stu = null;
		// id
		System.out.println("请输入编号");
		id = in.nextInt();
		stu.setId(id);
		// name
		System.out.println("请输入姓名");
		name = in.next();
		stu.setName(name);
		// sex
		System.out.println("请输入性别");
		sex = in.next();
		stu.setSex(sex);
		// age
		System.out.println("请输入年龄");
		age = in.nextInt();
		stu.setAge(age);
		// math
		System.out.println("请输入数学成绩");
		math = in.nextInt();
		stu.setMath(math);
		// computer
		System.out.println("请输入计算机成绩");
		computer = in.nextInt();
		stu.setComputer(computer);
		// Flanguage
		System.out.println("请输入外语成绩");
		Flanguage = in.nextInt();
		stu.setFlanguage(Flanguage);
		return true;
	}

	

	

}
