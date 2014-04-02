package Main;

import java.util.Collections;

import student.*;
import studentscore.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studata db = new studata();

		file f = new file();
		score s = new score();
		
		db.add(new info(2,"zhq",27));
		db.add(new student(4,"yxm",23,"SS"));
		db.add(new info(1,"zzz",24));
		db.add(new student(3,"zhq",25,"SS"));
		db.add(new student(5,"zhq",26,"A"));
		
		db.sort();		
		db.print();
		System.out.println();
		db.schoolsort();
		db.print();
		System.out.println();
		
		f.write(db);
		db=(studata)f.read();
		db.delete(5);
		db.sort();
		db.print();
		System.out.println();
		
		s.add(new mark(1,78,"SE"));
		s.add(new mark(1,98,"SE"));
		s.add(new mark(3,74,"SE"));
		s.add(new mark(4,86,"SE"));
		s.add(new mark(4,85,"SE"));
		
		System.out.println(connect.showtext((studata)db, s));
	}
}
