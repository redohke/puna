package fi.omapizzeria.sivusto.bean;

/**
 * 
 * Tämän luokka sisältää Asiakkaan tietosisällön.
 * @author Joona
 *
 */


public class Asiakas {

	
	private int id;
	private String etunimi, sukunimi, yritys, puh, email, osoite, postnro, kaupunki;
	
	public Asiakas(String etunimi, String sukunimi, String yritys,
			String puh, String email, String osoite, String postnro,
			String kaupunki) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.yritys = yritys;
		this.puh = puh;
		this.email = email;
		this.osoite = osoite;
		this.postnro = postnro;
		this.kaupunki = kaupunki;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEtunimi() {
		return etunimi;
	}


	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}


	public String getSukunimi() {
		return sukunimi;
	}


	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}


	public String getYritys() {
		return yritys;
	}


	public void setYritys(String yritys) {
		this.yritys = yritys;
	}


	public String getPuh() {
		return puh;
	}


	public void setPuh(String puh) {
		this.puh = puh;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getOsoite() {
		return osoite;
	}


	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}


	public String getPostnro() {
		return postnro;
	}


	public void setPostnro(String postnro) {
		this.postnro = postnro;
	}


	public String getKaupunki() {
		return kaupunki;
	}


	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	@Override
	public String toString() {
		return "Asiakas [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", yritys=" + yritys + ", puh=" + puh + ", email="
				+ email + ", osoite=" + osoite + ", postnro=" + postnro
				+ ", kaupunki=" + kaupunki + "]";
	}
	
}
