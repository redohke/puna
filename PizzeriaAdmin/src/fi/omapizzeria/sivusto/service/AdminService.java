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

public class AdminService {

	public AdminService() throws DAOPoikkeus {
		super();
	}

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
	
	public ArrayList<Tayte> haeTaytelistaAdmin() throws DAOPoikkeus {
		 ArrayList<Tayte> taytteet;
		 AdminDAO dao = new AdminDAO();
		 
		 taytteet = dao.haeTaytelista();
		
		return taytteet;
	}
	
	public ArrayList<Tuote> haeJuomalistaAdmin() throws DAOPoikkeus {
		 ArrayList<Tuote> juomat;
		 AdminDAO dao = new AdminDAO();
		 
		 juomat = dao.haeJuomatAdmin();
		
		return juomat;
	}
	
	public void viePizza(Pizza p, String[] taytteet) throws DAOPoikkeus {

		AdminDAO dao = new AdminDAO();
		List<Integer> tayteLista = new ArrayList<Integer>();

		for (String s : taytteet) {
			tayteLista.add(Integer.parseInt(s));
		}
		dao.lisaaPizza(p, tayteLista);
	}
	
	public void vieJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();

		dao.lisaaJuoma(j);
	}
	
	public void poistaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.poistaPizza(p);
	}
	
	public void poistaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.poistaJuoma(j);
	}
	
	public void piilotaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.piilotaJuoma(j);
	}
	
	public void piilotaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.piilotaPizza(p);
	}
	
	public void palautaJuoma(Juoma j) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.palautaJuoma(j);
	}
	
	public void palautaPizza(Pizza p) throws DAOPoikkeus {
		AdminDAO dao = new AdminDAO();
		
		dao.palautaPizza(p);
	}
	
}