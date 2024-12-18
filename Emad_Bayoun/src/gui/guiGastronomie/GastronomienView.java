package gui.guiGastronomie;


import business.Cafe;
import business.CafeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class GastronomienView {
	private CafeModel cafeModel;
	private GastronomienControl gastronomienControl;
	
	private Pane pane = new  Pane();
	private Label lblAnzeigeCafes     = new Label("Anzeige Cafes");
	private TextArea txtAnzeigeCafes  = new TextArea();
	private Button btnAnzeigeCafes 	  = new Button("Anzeige");

	
	public GastronomienView(Stage primaryStage, GastronomienControl gastronomienControl, CafeModel cafeModel) {
		this.gastronomienControl = gastronomienControl;
		this.cafeModel = cafeModel;
		
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Gastronomien");

    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}
	
	
	private void initKomponenten(){
		Font font = new Font("Arial", 20);
       	lblAnzeigeCafes.setLayoutX(310);
    	lblAnzeigeCafes.setLayoutY(40);
    	lblAnzeigeCafes.setFont(font);
		lblAnzeigeCafes.setStyle("-fx-font-weight: bold;"); 
		pane.getChildren().add(lblAnzeigeCafes);           	
    	txtAnzeigeCafes.setEditable(false);
 		txtAnzeigeCafes.setLayoutX(310);
		txtAnzeigeCafes.setLayoutY(90);
 		txtAnzeigeCafes.setPrefWidth(220);
		txtAnzeigeCafes.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeCafes);        	
      	btnAnzeigeCafes.setLayoutX(310);
    	btnAnzeigeCafes.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeCafes);


   }
   
   private void initListener() {
	   btnAnzeigeCafes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	zeigeCafeAn();
            }
	    });
    }

   
    void zeigeCafeAn(){
    	if(cafeModel.getCafes().size()>0) {
    		StringBuffer text = new StringBuffer();
    		for (Cafe cafe : cafeModel.getCafes()) {
    			text.append(cafe.gibCafeZurueck(' ')+"\n");
    			
			}
    		txtAnzeigeCafes.setText(text.toString());
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Cafe aufgenommen!");
    	}
    }    
		  
    void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
}
