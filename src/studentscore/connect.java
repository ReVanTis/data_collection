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
				text=text+"ѧ��:"+stu.no+" ����:"+stu.name+" ����:"+stu.age+" ѧԺ��"+stu.school+" �ܳɼ���"+temp+"\n";
			}				
			else {
				text=text+"ѧ��:"+stu.no+" ����:"+stu.name+" ����:"+stu.age+" ѧԺ��"+stu.school+"\n";
			}
		}
		return text;
	}
}
