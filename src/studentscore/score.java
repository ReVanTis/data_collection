package studentscore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class score {
	public Vector<mark> marks;
	public Map map;
	public score() {
		// TODO Auto-generated constructor stub
		marks = new Vector<mark>();
		map=new HashMap<Integer ,Integer>();
	}
	public void add(mark m)
	{
		marks.add(m);
	}
	
}
