package gui.guiGastronomie;

import business.*;
import javafx.stage.Stage;
import ownUtil.Observer;

public class GastronomienControl implements Observer{
	private GastronomienView gastronomienView;
	private CafeModel cafeModel;
	
	
	public GastronomienControl(Stage primaryStage) {
		
		this.cafeModel = CafeModel.getInstance();
		this.gastronomienView = new GastronomienView(primaryStage,this,cafeModel);
		
		cafeModel.addObserver(this);
		
	}


	@Override
	public void update() {
		gastronomienView.zeigeCafeAn();
		
	}
	

}
