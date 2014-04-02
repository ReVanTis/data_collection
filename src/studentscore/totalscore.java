package studentscore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class totalscore {
	public totalscore()
	{
		//
	}
	public void tp(score s)
	{
		Iterator<mark> it;
		it=s.marks.iterator();
		s.map.clear();
		
		while (it.hasNext()) {
			mark m = it.next();
			try {
				int temp = (int) s.map.get(m.no);
				int total = temp + m.grade;
				s.map.remove(m.no);	
				s.map.put(m.no,total);
			} catch (NullPointerException e) {
				// TODO: handle exception
				s.map.put(m.no,m.grade);
				continue;
			}
		}
		Set keys = s.map.keySet();
		for (Object object : keys) {
			System.out.println(object+":"+s.map.get(object));
		}
	}
}
