package student;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import Main.data;
import Main.info;

public class studata extends data{
	public Vector<student> studata;
	
	public studata()
	{
		studata = new Vector<student>();
	}
	public void sort()
	{
		super.sort();
		Collections.sort(studata);
	}
	public void schoolsort() {
		Collections.sort(studata, new SchoolComparator());
	}
	public void delete(int n) {
		super.delete(n);
		Iterator<student> iterator = studata.iterator();
		while (iterator.hasNext()) {
			student del = (student) iterator.next();
			if (del.no == n) {
				iterator.remove();
			}
		}
	}
	public void add(info in)
	{
		if(in instanceof student)
			studata.add((student)in);
		else
		data.add(in);
	}
	public void clear()
	{
		studata.clear();
		data.clear();
	}
	public void print() {
		super.print();
		Iterator<student> iterator = studata.iterator();
		while (iterator.hasNext()) {
			student student = (student) iterator.next();
			System.out.println("ѧ��:"+student.no+" ����:"+student.name+" ����:"+student.age+" ѧԺ��"+student.school);
		}
	}
	public String datatext() {
		super.datatext();
		String text="";
		for (student stu : studata) {
			text=text+"ѧ��:"+stu.no+" ����:"+stu.name+" ����:"+stu.age+" ѧԺ��"+stu.school+"\n";
		}
		return text;
	}
}

