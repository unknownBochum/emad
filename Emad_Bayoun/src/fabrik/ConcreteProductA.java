package fabrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	
	private BufferedReader ein;
	
	public ConcreteProductA() {
		try {
			ein = new BufferedReader(new FileReader("cafe.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] leseAusDatei() throws IOException {
  		String[] zeile = ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		ein.close();
		
	}

}
