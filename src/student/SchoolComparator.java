package student;

import java.util.Comparator;

public class SchoolComparator implements Comparator<student>{
	public int compare(student s1, student s2) {
		String sc1=s1.school.toLowerCase();
		String sc2=s2.school.toLowerCase();
		if (sc1.equals(sc2)) {
			return s1.no-s2.no;
		}
		return sc1.compareTo(sc2);
	}
}
