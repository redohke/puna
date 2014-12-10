package fi.omapizzeria.sivusto.dao;

/**
 * Tämä luokka sisältää virheilmoituksen jos käyttäjänimi löytyy jo tietokannasta.
 * @author Aleksi, Joona
 *
 */
public class UsernameVarattuPoikkeus extends Exception {
	private static final long serialVersionUID = 1L;

	public UsernameVarattuPoikkeus() {
		super(
				"Username on jo varattuna jollain toisella käyttäjällä tietokannassa.");
	}
}