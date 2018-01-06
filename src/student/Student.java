package student;

import person.Person;

public class Student extends Person {// 编号，姓名，性别，年龄，数学成绩，计算机成绩，外语成绩。
	private int id;
	private int math;
	private int computer;
	private int Flanguage;
	private int sum;
	private double ave;
	private int rank;
	public Student() {
		
	}
	public Student(int id, String name, int age, String sex, int math, int computer, int flanguage) {
		super(name, age, sex);
		this.id = id;
		this.math = math;
		this.computer = computer;
		Flanguage = flanguage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getFlanguage() {
		return Flanguage;
	}

	public void setFlanguage(int flanguage) {
		Flanguage = flanguage;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAve() {
		return ave;
	}

	public void setAve(double ave) {
		this.ave = ave;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void cal_sum(Student stu) {
		stu.sum = stu.computer + stu.math + stu.Flanguage;
		
	}

	public void cal_ave(Student stu) {
		cal_sum(stu);
		stu.ave = stu.sum / 3;
	}
	public void print_stu_info(Student stu) {
		System.out.print(stu.getId());
		System.out.print(" ");
		System.out.print(stu.getName());
		System.out.print(" ");
		System.out.print(stu.getAge());
		System.out.print(" ");
		System.out.print(stu.getSex());
		System.out.print(" ");
		System.out.print(stu.getMath());
		System.out.print(" ");
		System.out.print(stu.getComputer());
		System.out.print(" ");
		System.out.print(stu.getFlanguage());
		System.out.println();
	}
}
