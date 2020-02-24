package layout;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import util.ImgUtil;

public class MenuCorona extends Menu {
	private MenuItem miConfirmedCases, miDeaths, miRecoveries, miTotals, miIndividualBarChart;
	
	public MenuCorona(BorderPane root) {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		miTotals= new MenuItem("Global Totals");
		miIndividualBarChart= new MenuItem("Individual Totals");
		

		TotalsBarSetup barSet = new TotalsBarSetup();
		TotalsBarSetup individualBarSet= new TotalsBarSetup();
		IndividualTotalBox iTB = new IndividualTotalBox(individualBarSet.getBarChart());
		TotalsBox bigTBox = new TotalsBox(barSet.getBarChart());
		HBox totalsBox = bigTBox.getTotalsBox();
		HBox individualTotalBox= iTB.getTotalsBox();
		
		miConfirmedCases.setOnAction(e -> {
			root.setCenter(new CoronaConfirmedSearchPane());
		});

		miDeaths.setOnAction(e -> {
			root.setCenter(new CoronaDeathSearchPane());
		});

		miRecoveries.setOnAction(e -> {
			root.setCenter(new CoronaRecoveredSearchPane());
		});
		
		miTotals.setOnAction(e -> {
			root.setCenter(totalsBox);
		});
		miIndividualBarChart.setOnAction(e->{
			root.setCenter(individualTotalBox);
		});
		
		this.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries, miTotals,miIndividualBarChart );
		this.setGraphic(ImgUtil.loadImgVScale(ImgUtil.CORONAVIRUS_ICO,16.0,16.0));
	}
}
