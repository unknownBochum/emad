package main;

import gui.guiCafe.CafeControl;
import gui.guiGastronomie.GastronomienControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new CafeControl(primaryStage);
		//new CafeAnwendersystem(primaryStage);
		Stage secondryStage = new Stage();
		new GastronomienControl(secondryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
 