package gui.guiCafe;
import java.io.IOException;

import business.*;
import javafx.stage.Stage;
import ownUtil.Observer;

public class CafeControl implements Observer{
	private CafeView cafeView;
	private CafeModel cafeModel;
	
	
	public CafeControl(Stage primaryStage){
		
		this.cafeModel = CafeModel.getInstance();
		this.cafeView = new CafeView(primaryStage,this,cafeModel);
		
		cafeModel.addObserver(this);
		
	}
	
    public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			cafeModel.leseAusDateiCsv();
      			//cafeView.zeigeInformationsfensterAn("Cafe wurden gelesen!");
      		}else{
      			cafeModel.leseAusDateiTxt();
      			//cafeView.zeigeInformationsfensterAn("Cafe wurden gelesen!");
      		}
		}catch(IOException exc){
			cafeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			cafeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeCafeInCsvDatei() {
		try {
			cafeModel.schreibeCafeInCsvDatei();
   			cafeView.zeigeInformationsfensterAn("Cafe wurden gespeichert!");
		}	
		catch(IOException exc){cafeView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		}
		catch(Exception exc){cafeView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		cafeView.zeigeCafeAn();
		
	}
	

}
