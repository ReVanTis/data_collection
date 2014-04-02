package studentscore;

import javax.xml.soap.Text;

import student.studata;
import student.student;

public class connect {
	static public String showtext(studata sd,score sc) {
		String text = "";
		totalscore ts = new totalscore();
		ts.tp(sc);
		
		for (student stu : sd.studata) {
			Integer temp=(Integer)sc.map.get(stu.no);
			
			if (temp!=null) {
				text=text+"学号:"+stu.no+" 姓名:"+stu.name+" 年龄:"+stu.age+" 学院："+stu.school+" 总成绩："+temp+"\n";
			}				
			else {
				text=text+"学号:"+stu.no+" 姓名:"+stu.name+" 年龄:"+stu.age+" 学院："+stu.school+"\n";
			}
		}
		return text;
	}
}
