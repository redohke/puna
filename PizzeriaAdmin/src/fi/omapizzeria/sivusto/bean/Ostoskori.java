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
			tuotteita += ostos.getoId();
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
	
	
	
	int i = 1;
	
	
	public void lisaaTuote(Pizza pizza, int lkm, boolean oregano, boolean valkosipuli) {
		
		int oId = ostokset.size() +1;
		Ostos ostos = new Ostos(oId, pizza, lkm, oregano, valkosipuli);
		
		if (ostos != null) {
			
			ostos.muutaOid(i);
			
				if ( oregano == true && valkosipuli == true) {
					
					
					ostokset.add(new Ostos(oId, pizza, lkm, true, true));
					
		}
				
				else if	( oregano == false && valkosipuli == true) {
					
					ostokset.add(new Ostos(oId, pizza, lkm, true, false));
		}
		
				else if ( oregano == true && valkosipuli == false) {
					
					ostokset.add(new Ostos(oId, pizza, lkm, false, true));
		}
		
		
				else { 	
					
					ostokset.add(new Ostos(oId, pizza, lkm, false, false));
		}
		
				i = i +1;
		}
		
	}
	
				
				
				
		
			
			//ostokset.add(new Ostos(oId, lisattava, lkm, valkosipuli, oregano));

	
	public ArrayList<Ostos> ostokset() {
		return ostokset;
	}
	

	
	public void tyhjenna() {
		ostokset.clear();
	}
	
	
/*	public void poista(Ostos poistettava) {
		Ostos ostos = etsituote(poistettava);
			if (ostos.getoId()>1) {
				ostos.vahennaLukumaaraa();
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
	
	*/
	
	
	
}
