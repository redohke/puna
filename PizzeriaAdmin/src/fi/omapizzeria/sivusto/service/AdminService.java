package fi.omapizzeria.sivusto.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.dao.AdminDAO;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;

public class AdminService {
	
	public AdminService() throws DAOPoikkeus {
		super();
	}
	
	public void viePizza(Pizza p, String[] taytteet) throws DAOPoikkeus{
			
		AdminDAO dao = new AdminDAO();
		
		ArrayList taytelista = new ArrayList(taytteet);
		
		Iterator iterator = taytelista.iterator();
		
		
		while (iterator.hasNext()) {
			
			
			String str = (String) iterator.next();
		
		
		}
		
		
	
		
		
	}
	

}
	

