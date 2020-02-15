package app;

import java.io.IOException;

import model.CoronaDatabase;
import util.DataParser;

public class Demo {

	public static void main(String[] args) throws IOException {
		CoronaDatabase saveCorona = DataParser.importCorona();
		System.out.println(saveCorona.getCoronaConfirmed().get(10).getDeathsConfirmedOrRecovered());
	}

}
