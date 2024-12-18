package business;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

class Test {

	// 
	// Einagbe ==>  Worp, Essen,B�ckerei,ja,Milchkaffee_Cafe Crema
	//
	@org.junit.jupiter.api.Test
	void test() {
		String[] produckte = {"Milchkaffee","Cafe Crema"};
		Cafe cafe = new Cafe("Worp", "Essen", "B�ckerei", true, produckte);
		BooleanSupplier booleanSupplier = ()->cafe.getName().equals("Worp");
		assertTrue(booleanSupplier, "Fehler");
	}
	@org.junit.jupiter.api.Test
	void test1() {
		// NullPointerException
		assertThrows(IllegalArgumentException.class, () -> {
			new Cafe("Worp", "Essen", "B�ckerei", true, null);});
		}

}
