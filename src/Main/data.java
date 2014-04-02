package Main;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class data implements Serializable
{
	public Vector<info> data;
	public void clear()
	{
		data.clear();
	}
	public data()
	{
		data = new Vector<info>();
	}
	public void add(info in)
	{
		data.add(in);
	}
	public void sort()
	{
		Collections.sort(data);
	}
	public void delete(int n) {
		Iterator<info> iterator = data.iterator();
		while (iterator.hasNext()) {
			info del = (info) iterator.next();
			if (del.no==n) {
				iterator.remove();
			}
		}
	}
	public void print() {
		Iterator<info> iterator = data.iterator();
		while (iterator.hasNext()) {
			info student = (info) iterator.next();
			System.out.println("ѧ��:"+student.no+" ����:"+student.name+" ����:"+student.age);
		}
	}
	public String datatext() {
		String text="";
		for (info in : data) {
			text=text+"ѧ��:"+in.no+" ����:"+in.name+" ����:"+in.age+"\n";
		}
		return text;
	}
}


