package util;

import java.io.File;
import java.util.Arrays;

public class CamposUtils {
	public static void main(String[] args) {
		String s = " 1.0";
		System.out.println(s.trim());
	}
	
	public static File[] scanFiles(String dir) {
		return new File(dir).listFiles();
	}
	
	public static String editCommas(String s) {
		return s.replaceAll(",", ", ");
	}
}
