package students;

import java.util.ArrayList;
import java.util.Iterator;

import student.Student;

public class Students {
	//Student stu;
	public static ArrayList<Student> list = new ArrayList<Student>();
	public Students() {
		System.out.println("创建了students对像"+list.size());
	}
	public static void add_stu(Student stu) {
		list.add(stu);
	}

	public static void delete_stu(Student stu) {
		list.remove(stu);
	}

	// query by id
	public static Student query_by_id(int id) {
		Iterator<Student>it = list.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			if(s.getId() == id) {
				return s;
			}
		}
		//System.out.println("按编号查找失败，此学生不存在");
		return null;

	}

	// query by name
	public static Student query_by_name(String name) {
		Iterator<Student>it = list.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			if(s.getName().equals(name)) {
				return s;
			}
		}
		//System.out.println("按姓名查找失败，此学生不存在");
		return null;
	}
	public ArrayList<Student> query_by_grade_and_sex(String sex, int sum) {
		ArrayList<Student> res = null;
		Iterator<Student>it = list.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			if(s.getSex() == sex && s.getSum() == sum) {
				res.add(s);
			}
		}
		return list;
	}
}
