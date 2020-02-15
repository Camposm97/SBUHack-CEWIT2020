package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LightWork {
	public static Object readObject(String src) {
		Object o = null;
		try {
			File file = new File(src);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
			System.out.println("Successfully loaded Object from: " + file);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static boolean writeObject(Object o, String src) {
		try {
			File file = new File(src);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			System.out.println("Successfully saved Object to: " + file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
