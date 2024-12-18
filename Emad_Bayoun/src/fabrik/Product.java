package fabrik;

import java.io.IOException;

public abstract class Product {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
