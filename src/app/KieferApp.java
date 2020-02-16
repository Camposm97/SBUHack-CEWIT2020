package app;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import model.CoronaData;
import model.CoronaDatabase;
import util.DataParser;

public class KieferApp {

	public static void main(String[] args) throws IOException {
		String s="china";
		List<CoronaData> cD=findByArea(s);
		

	}
	public static List<CoronaData> findByArea(String area) throws IOException {
		CoronaDatabase coronaDatabase= DataParser.importCorona();
		List<CoronaData> list = coronaDatabase.getCoronaConfirmed();
		List<CoronaData> resultList = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCountryOrRegion().toLowerCase().contains(area.toLowerCase())) {
				resultList.add(list.get(i));
			}
		}
		return resultList;

}
}
