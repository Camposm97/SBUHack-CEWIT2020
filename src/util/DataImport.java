package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import model.CoronaVirusInfo;

public class DataImport {
	public static LinkedList<CoronaVirusInfo> importCoronaData(File importFile) {
		File f= importFile;
		Scanner in;
		LinkedList<CoronaVirusInfo> theList= new LinkedList<>();
		try {
			in= new Scanner(f);
		} catch (FileNotFoundException e) {
			in=null;
			e.printStackTrace();
		}
		String province;
		String stateOrCountry;
		String lastUpdate;
		int confirmedCases;
		int deaths;
		int recovered;
		while(in.hasNextLine()) {
			String currentLine=in.nextLine();
			String[] tokens= new String[6];
			int length=tokens.length;
			int tokenCount=0;
			int currentPosition=0;
			int offSet;
			for (int i=0;i<currentLine.length();i++) {
				offSet= currentLine.substring(currentPosition,currentLine.indexOf(',')).length();
				tokens[tokenCount]=currentLine.substring(0,currentLine.substring(currentPosition,currentLine.length()).indexOf(','));
				currentPosition=currentPosition+offSet;
				tokenCount++;
			}
			province=tokens[0];
			stateOrCountry=tokens[1];
			lastUpdate=tokens[2];
			//if (tokens.len)
			if (tokens[3].charAt(0)>'9'||tokens[3].charAt(0)<'0') {
				confirmedCases=0;
			}else {
				confirmedCases=Integer.parseInt(tokens[3]);
			}
			if (tokens[4].charAt(0)>'9'||tokens[4].charAt(0)<'0') {
				deaths=0;
			}else {
				deaths=Integer.parseInt(tokens[4]);
			}
			if(tokens[5].charAt(0)>'9'||tokens[5].charAt(0)<'0') {
				recovered=0;
			}else {
				recovered=Integer.parseInt(tokens[5]);
			}
			CoronaVirusInfo cvi= new CoronaVirusInfo(province,stateOrCountry,lastUpdate,confirmedCases,deaths,recovered);
			theList.add(cvi);
		}
		return theList;
	}
}
