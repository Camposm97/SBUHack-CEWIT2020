package app;

import java.io.IOException;

import model.CoronaDatabase;
import util.DataParser;

@Deprecated
public class Demo {

	public static void main(String[] args) throws IOException {
		CoronaDatabase coronaDb = DataParser.importCorona();
		System.out.println(coronaDb.getCoronaConfirmed().get(10).getCountList());
	}

}
