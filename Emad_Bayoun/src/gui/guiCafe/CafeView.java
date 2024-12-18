package gui.guiCafe;


import business.Cafe;
import business.CafeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class CafeView {
	private CafeModel cafeModel;
	private CafeControl cafeControl;
	
	private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblOrt   					= new Label("Ort:");
    private Label lblBeschreibung  	 		= new Label("Beschreibung:");
    private Label lblBaecker   				= new Label("angeschlossener BÃ¤ckerei:");
    private Label lblKaffeeprodukte  		= new Label("Kaffeeprodukte:");
    
    private TextField txtName 	 			= new TextField();
    private TextField txtOrt				= new TextField();
    private TextField txtBeschreibung		= new TextField();
    private TextField txtBaecker			= new TextField();
    private TextField txtKaffeeprodukte		= new TextField();
    
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
	
	public CafeView(Stage primaryStage, CafeControl cafeControl, CafeModel cafeModel) {
		this.cafeControl = cafeControl;
		this.cafeModel = cafeModel;
		
		
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Cafes");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}
	
	
	private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblOrt.setLayoutX(20);
    	lblOrt.setLayoutY(130);
    	lblBeschreibung.setLayoutX(20);
    	lblBeschreibung.setLayoutY(170);
    	lblBaecker.setLayoutX(20);
    	lblBaecker.setLayoutY(210);
    	lblKaffeeprodukte.setLayoutX(20);
    	lblKaffeeprodukte.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblOrt, lblBeschreibung,
       		lblBaecker, lblKaffeeprodukte);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtOrt.setLayoutX(170);
    	txtOrt.setLayoutY(130);
    	txtOrt.setPrefWidth(200);
    	txtBeschreibung.setLayoutX(170);
    	txtBeschreibung.setLayoutY(170);
    	txtBeschreibung.setPrefWidth(200);
    	txtBaecker.setLayoutX(170);
    	txtBaecker.setLayoutY(210);
    	txtBaecker.setPrefWidth(200);
    	txtKaffeeprodukte.setLayoutX(170);
    	txtKaffeeprodukte.setLayoutY(250);
    	txtKaffeeprodukte.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtOrt, txtBeschreibung,
     		txtBaecker, txtKaffeeprodukte);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	nehmeCafeAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		zeigeCafeAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(e->leseAusDatei("csv"));

	    mnItmTxtImport.setOnAction(e->leseAusDatei("txt"));

	    mnItmCsvExport.setOnAction(e->schreibeCafeInCsvDatei());
    }
    
    private void nehmeCafeAuf(){
    	try{
    		// hier kleine Änderung
    		cafeModel.addCafe(new Cafe(
    			txtName.getText(), 
   	            txtOrt.getText(),
   	            txtBeschreibung.getText(),
   	            Boolean.parseBoolean(txtBaecker.getText()),
    		    txtKaffeeprodukte.getText().split(";")));
    		
    		cafeModel.notifyObservers();
    		
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    // hier Änderung
    void zeigeCafeAn(){
    	if(cafeModel.getCafes().size()>0) {
    		StringBuffer text = new StringBuffer();
    		for (Cafe cafe : cafeModel.getCafes()) {
    			text.append(cafe.gibCafeZurueck(' ')+"\n");
			}
    		txtAnzeige.setText(text.toString());
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Cafe aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	cafeControl.leseAusDatei(typ);
    	cafeModel.notifyObservers();
	}
		
	private void schreibeCafeInCsvDatei() {
		cafeControl.schreibeCafeInCsvDatei();
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
