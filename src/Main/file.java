package Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class file {
	File file;
	
	public file() {
		// TODO Auto-generated constructor stub
		file = new File("D:\\","student.txt");
	}
	public file(File f) {
		// TODO Auto-generated constructor stub
		file = f;
	}
	
	public void write(data d) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream obs = new ObjectOutputStream(fos);
				obs.writeObject(d);		
				obs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public data read() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream obs = new ObjectInputStream(fis);
			data rt=(data) obs.readObject();
			obs.close();
			return rt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			return null;
		}
	}
}
	
