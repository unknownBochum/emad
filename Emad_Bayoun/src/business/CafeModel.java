package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import fabrik.ConcreteCreatorA;
import fabrik.ConcreteCreatorB;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class CafeModel implements Observable{
	
	private static CafeModel ob;
	//private Cafe cafe;
	private Vector<Observer> observers = new Vector<Observer>();
	
	// Hier Änderung ==>
	private ArrayList<Cafe> cafes = new ArrayList();

	private CafeModel() {}
	
	public static CafeModel getInstance() {
		if (ob== null) {
			ob = new CafeModel();
		}
		return ob;
	}

	// Hier Änderung ==>
	public ArrayList<Cafe> getCafes() {
		return cafes;
	}

	public void addCafe(Cafe cafe) {
		cafes.add(cafe);
	}
	
	// Hier Änderung (for each)==> 
	public void schreibeCafeInCsvDatei() throws IOException{
			BufferedWriter aus = new BufferedWriter(new FileWriter("CafeAusgabe.csv", true));
			// Hier 
			for (Cafe cafe : cafes) {
				aus.write(cafe.getName()+"\n");
				aus.write(cafe.getOrt()+"\n");
				aus.write(cafe.getBeschreibung()+"\n");
				aus.write(cafe.getBaeckerei()+"\n");
				aus.write(cafe.getKaffeeprodukteAlsString('_')+"\n");
				aus.newLine();
			}
			aus.close();
	}
	
	// Hier kleine Änderung (add)==>
	public void leseAusDateiCsv() throws IOException{	
      		Creator creator = new ConcreteCreatorA();
      		Product reader = creator.factoryMethod();
      		
      		String[] zeile = reader.leseAusDatei();
      		cafes.add(new Cafe(zeile[0], 
      				zeile[1], zeile[2], 
      				Boolean.parseBoolean(zeile[3]), zeile[4].split("_")));
      			
      		reader.schliesseDatei();
      				
 
	}
	// Hier kleine Änderung (add)==>
	public void leseAusDateiTxt() throws IOException{	
  		Creator creator = new ConcreteCreatorB();
  		Product reader = creator.factoryMethod();
  		
  		String[] zeile = reader.leseAusDatei();
  		cafes.add(new Cafe(zeile[0], 
  				zeile[1], zeile[2], 
  				Boolean.parseBoolean(zeile[3]), zeile[4].split("_")));
  			
  		reader.schliesseDatei();
  				

	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}
		
}
