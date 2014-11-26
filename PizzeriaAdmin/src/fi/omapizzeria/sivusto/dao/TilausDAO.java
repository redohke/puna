package fi.omapizzeria.sivusto.dao;

import fi.omapizzeria.sivusto.bean.Ostos;
import fi.omapizzeria.sivusto.bean.Tilaus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class TilausDAO extends DAO {

	public TilausDAO() throws DAOPoikkeus {
		

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	
	
	public void lisaaTilaus(Tilaus tilaus) throws DAOPoikkeus {
		
		
//		avataan yhteys
		Connection yhteys = avaaYhteys();
		
	try {
			
			String sqlAsiakas = "insert into asiakas(etunimi, sukunimi, yritys, puhelin, sposti, osoite, postinumero, kaupunki) values(?,?,?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sqlAsiakas);
			
			//t‰ytet‰‰n puuttuvat tiedot
			
				lause.setString(1, tilaus.getAsiakas().getEtunimi());
				lause.setString(2, tilaus.getAsiakas().getSukunimi());
				lause.setString(3, tilaus.getAsiakas().getYritys());
				lause.setString(4, tilaus.getAsiakas().getPuh());
				lause.setString(5, tilaus.getAsiakas().getEmail());
				lause.setString(6, tilaus.getAsiakas().getOsoite());
				lause.setString(7, tilaus.getAsiakas().getPostnro());
				lause.setString(8, tilaus.getAsiakas().getKaupunki());
				
			lause.executeUpdate();	
			
			
			String sqlKori = "insert into tilausrivi(pizza_id, juoma_id, kpl, hinta, oreg, vsip) values(?,?,?,?,?,?)";
			PreparedStatement lauseKori = yhteys.prepareStatement(sqlKori);
			
		for (int i = 0; i < tilaus.getOstoskori().getOstokset().size(); i++) {
			ArrayList<Ostos> ostokset = tilaus.getOstoskori().getOstokset();
			
			Tuote tuote = ostokset.get(i).getTuote().getNimi()
		}
			
			if (tilaus.getOstoskori().getClass().getSimpleName() == "Pizza") {
				
				//jos tilauksessa pizza
				lauseKori.setString(1, tilaus.getOstoskori().getOstokset();
			} else {
				
				//jos tilauksessa juoma
				lauseKori.setString(2, tilaus.getOstoskori().getOstokset().;
			}
			
			
		} catch (Exception e) {
			
		}
		
		
		
	}
	
	
	
	
}
