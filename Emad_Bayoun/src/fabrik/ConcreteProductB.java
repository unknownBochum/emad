package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product {
	
	private BufferedReader ein;
	
	public ConcreteProductB() {
		try {
			ein = new BufferedReader(new FileReader("cafe.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] leseAusDatei() throws IOException {
  		String[] ergebnisZeile = new String[5];
  		String zeile = ein.readLine();
  		int i = 0;
  		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

}
