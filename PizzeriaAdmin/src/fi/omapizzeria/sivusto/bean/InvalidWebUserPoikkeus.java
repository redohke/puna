package fi.omapizzeria.sivusto.bean;

/**
 * T‰m‰ luokka sis‰lt‰‰ virheilmoitukset liittyen WebUser luokan mahdollisiin virheisiin.
 * 
 *
 */

public class InvalidWebUserPoikkeus extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidWebUserPoikkeus(String viesti) {
			super(viesti);
	}
}
