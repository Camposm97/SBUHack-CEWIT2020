package util;

import java.io.File;
import java.util.Arrays;

public class CamposUtils {
	public static void main(String[] args) {
		File folder = new File("res/archived_data/daily_case_updates");
		File[] arr = folder.listFiles();
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < folder.length() - 1; i++) {
			File file = arr[i];
			if (file.isFile()) {
				System.out.println(file.getName());			
			}
		}
	}
	
	public static File[] scanFiles(String dir) {
		return new File(dir).listFiles();
	}
}
