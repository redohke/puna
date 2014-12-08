package fi.omapizzeria.sivusto.service;

import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Juoma;
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.dao.AdminDAO;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
import fi.omapizzeria.sivusto.dao.TuoteDAO;



/** 
 * Tämä luokka välittää pyyntöjä AdminServletin ja AdminDAO:n välillä
 * @author Aleksi, Markus, Joona
 */

public class AdminService {

	public AdminService() throws DAOPoikkeus {
		super();
	}
	
	/** 
	 * Tämä metodi välittää AdminServletiltä saadun pyynnön AdminDAO:lle
	 * 
	 * @return Palauttaa AdminDAO:sta saadun pitsalistan.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */

	public ArrayList<Tuote> haePizzalistaAdmin() throws DAOPoikkeus {
		ArrayList<Tuote> pizzat;
		
		AdminDAO dao = new AdminDAO();
		TuoteDAO tDao = new TuoteDAO();
		
		pizzat = dao.haePizzatAdmin();
		
		for(Tuote t : pizzat) {
			t.setTaytteet(tDao.haeTaytteetPizzalle(t.getId()));
		}	
		return pizzat;
	}
	
	/**
	 * Tämä metodi palauttaa AdminServletiltä saadun pyynnön AdminDAO:lle
	 * @return Palauttaa AdminDAO:lta saadun täytelistan.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public ArrayList<Tayte> haeTaytelistaAdmin() throws DAOPoikkeus {
		 ArrayList<Tayte> taytteet;
		 AdminDAO dao = new AdminDAO();
		 
		 taytteet = dao.haeTaytelista();
		
		return taytteet;
	}
	
	/**
	 * Tämä metodi palauttaa AdminServletiltä saadun pyynnön AdminDAO:lle
	 * @return Palauttaa AdminDAO:lta saadun Juomalistan.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public ArrayList<Tuote> haeJuomalistaAdmin() throws DAOPoikkeus {
		 ArrayList<Tuote> juomat;
		 AdminDAO dao = new AdminDAO();
		 
		 juomat = dao.haeJuomatAdmin();
		
		return juomat;
	}
	
	/**
	 * Vie Servletissä luodun pizzan AdminDAO:lle.
	 * @param p Servletissä luotu pizza.
	 * @param taytteet Servletissä luotu täytelista.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void viePizza(Pizza p, String[] taytteet) throws DAOPoikkeus {

		AdminDAO dao = new AdminDAO();
		List<Integer> tayteLista = new ArrayList<Integer>();

		for (String s : taytteet) {
			tayteLista.add(Integer.parseInt(s));
		}
		dao.lisaaPizza(p, tayteLista);
	}
	
	/**
	 * Vie Servletissä luodun juoman AdminDAO:lle.
	 * @param j Servletissä luotu juoma.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void vieJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();

		dao.lisaaJuoma(j);
	}
	
	/**
	 * Vie AdminServletistä saadun poistopyynnön AdminDAO:lle
	 * @param p Poistettava pizza.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void poistaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.poistaPizza(p);
	}
	
	/**
	 * Vie AdminServletistä saadun poistopyynnön AdminDAO:lle
	 * @param p Poistettava juoma.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void poistaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.poistaJuoma(j);
	}
	
	/**
	 * Vie AdminServletistä saadun piilotuspyynnön AdminDAO:lle
	 * @param p Piilotettava juoma.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void piilotaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.piilotaJuoma(j);
	}
	
	/**
	 * Vie AdminServletistä saadun piilotuspyynnön AdminDAO:lle
	 * @param p Piilotettava pizza.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void piilotaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.piilotaPizza(p);
	}
	
	/**
	 * Vie AdminServletistä saadun näytä pyynnön AdminDAO:lle
	 * @param p Juoma jonka halutaan näkyvän menussa.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void palautaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.palautaJuoma(j);
	}
	
	/**
	 * Vie AdminServletistä saadun näytä pyynnön AdminDAO:lle
	 * @param p Pizza jonka halutaan näkyvän menussa.
	 * @throws DAOPoikkeus Antaa virheilmoituksen jos tietokantahaku ei toimi.
	 */
	
	public void palautaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.palautaPizza(p);
	}
	
}