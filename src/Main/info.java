package Main;

import java.io.Serializable;


public class info implements Comparable<info>,Serializable{
	public String name;
	public int age;
	public  int no;
	public info(int no,String n,int a)
	{
		this.no=no;
		name=n;
		age=a;
	}
	public info(){}
	
	@Override
	public int compareTo(info o) {
		// TODO Auto-generated method stub
		return this.no-o.no;
	}
}