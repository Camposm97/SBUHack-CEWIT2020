package util;

import java.io.File;
import java.util.Arrays;

public class CamposUtils {
	public static void main(String[] args) {
		String s = ",,,";
//		System.out.println(Arrays.toString(s.split(", ")));
		System.out.println(s.replaceAll(",", ", "));
	}
	
	public static File[] scanFiles(String dir) {
		return new File(dir).listFiles();
	}
	
	public static String editCommas(String s) {
		return s.replaceAll(",", ", ");
	}
}
