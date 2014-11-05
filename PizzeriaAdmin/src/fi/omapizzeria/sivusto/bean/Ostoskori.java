package fi.omapizzeria.sivusto.bean;

import java.util.ArrayList;

public class Ostoskori {

	private ArrayList<Ostos> ostokset;
	
	
public Ostoskori() {
	ostokset = new ArrayList<Ostos>();
}
	
	

public int tuotteitaKorissa() {
		int tuotteita = 0;
		
		
		
		for (Ostos ostos : ostokset) {
			tuotteita += ostos.lukumaara();
		}
		return tuotteita;
	}
	
	


	
	
	public double hinta() {
		int hinta = 0;
		
		for (Ostos ostos : ostokset) {
			hinta += ostos.hinta();
		}
		return hinta;
	}
	
	
	
	public void lisaaTuote(Pizza lisattava) {
		Ostos ostos = etsi(lisattava);
		
		if (ostos != null) {
			ostos.muutaLukumaaraa(1);
		} else {
			ostokset.add(new Ostos(lisattava));
		}
	}
	

	
	
	public ArrayList<Ostos> ostokset() {
		return ostokset;
	}
	
	
	
	public void tyhjenna() {
		ostokset.clear();
	}
	
	
	public void poista(Pizza poistettava) {
		Ostos ostos = etsi(poistettava);
			if (ostos.lukumaara()>1) {
				ostos.muutaLukumaaraa(-1);
			} else {
				ostokset.remove(ostos);
			}
		
	}
	
	private Ostos etsi(Pizza etsittava) {
		for (Ostos ostos: ostokset) {
			if (ostos.tuotteenId() == etsittava.getId()) {
				return ostos;
			}
		}
		return null;
	}
	
	
}
