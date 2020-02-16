package view;

import java.util.HashSet;

import app.App;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import model.CoronaData;
import model.CoronaDatabase;

public class MyPieChart {
	private VBox box;
	CoronaDatabase database;
	HashSet countrySet = new HashSet();
	
	public MyPieChart() {
		App.DB.getCoronaConfirmed();
		App.DB.getCoronaDeaths();
		App.DB.getCoronaRecovered();
		int totalConfirmed = App.DB.getTotalConfirmed();
		int totalDeaths = App.DB.getTotalDeaths();
		int totalRecovered = App.DB.getTotalRecovered();
		
		for (CoronaData cd : App.DB.getCoronaDeaths()) {
			countrySet.add(cd.getCountryOrRegion());
		}

		PieChart chart = new PieChart();
		PieChart.Data s1 = new PieChart.Data("Currently Ill", totalConfirmed - totalDeaths - totalRecovered);
		PieChart.Data s2 = new PieChart.Data("Deaths", totalDeaths);
		PieChart.Data s3 = new PieChart.Data("Recovered", totalRecovered);
		box = new VBox(chart);
		
		
	}
}
