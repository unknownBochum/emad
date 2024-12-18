package business;

import java.util.ArrayList;

public class Cafe {
	

    private String name;

    private String ort;
    private String beschreibung;

    private boolean baeckerei;

 // hier �nderung ==>
    private ArrayList<String> kaffeeprodukte;
    
    public Cafe(String name, String ort, String beschreibung,
    		boolean baeckerei, String[] kaffeeprodukten){
    	
    	if (kaffeeprodukten == null) {
             throw new IllegalArgumentException();
    	}
   		this.name = name;
  	    this.ort = ort;
   	    this.beschreibung = beschreibung;
   	    this.baeckerei = baeckerei;
   	    // hier �nderung
   	    this.setKaffeProdukteAusStringArray(kaffeeprodukten);
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public boolean getBaeckerei() {
		return baeckerei;
	}

	public void setBaeckerei(boolean baeckerei) {
		this.baeckerei = baeckerei;
	}


	// hier �nderung ==>
	public ArrayList<String> getKaffeeprodukte() {
		return kaffeeprodukte;
	}
	// hier �nderung ==>
	public void setKaffeeprodukte(ArrayList<String> kaffeeprodukte) {
		this.kaffeeprodukte = kaffeeprodukte;
	}
	
	// hier �nderung ==>
	public void setKaffeProdukteAusStringArray(String[] kaffeeprodukten) {
		this.kaffeeprodukte = new ArrayList<String>();
		for (int i = 0; i < kaffeeprodukten.length; i++) {
			kaffeeprodukte.add(kaffeeprodukten[i]);
		}
		
	}
	// hier �nderung ==> 
	public String getKaffeeprodukteAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getKaffeeprodukte().size() - 1; i++) {
			ergebnis = ergebnis + this.getKaffeeprodukte().get(i) + trenner; 
		}
		return ergebnis	+ this.getKaffeeprodukte().get(i);
	}
	
	public String gibCafeZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getBeschreibung() + trenner
  		    + this.getBaeckerei() + trenner + "\n"
  		    + this.getKaffeeprodukteAlsString(trenner) + "\n";
  	}
}

