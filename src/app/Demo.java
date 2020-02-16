package app;

import java.io.IOException;

import model.CoronaDatabase;
import util.CamposParser;

@Deprecated
public class Demo {

	public static void main(String[] args) throws IOException {
		CoronaDatabase coronaDb = CamposParser.importCoronaDB();
		System.out.println(coronaDb.getCoronaConfirmed().get(10).getCountList());
	}

}
