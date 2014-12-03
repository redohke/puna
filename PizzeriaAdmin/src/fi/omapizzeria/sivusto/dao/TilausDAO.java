package fi.omapizzeria.sivusto.dao;

import fi.omapizzeria.sivusto.bean.Ostos;
import fi.omapizzeria.sivusto.bean.Tilaus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {
			System.out.println(tilaus);
			
			String sqlAsiakas = "insert into asiakas(etunimi, sukunimi, yritys, puhelin, sposti, osoite, postinumero, kaupunki) values(?,?,?,?,?,?,?,?)";
			PreparedStatement prest = yhteys.prepareStatement(sqlAsiakas, Statement.RETURN_GENERATED_KEYS);

			// t‰ytet‰‰n puuttuvat tiedot

			prest.setString(1, tilaus.getAsiakas().getEtunimi());
			prest.setString(2, tilaus.getAsiakas().getSukunimi());
			prest.setString(3, tilaus.getAsiakas().getYritys());
			prest.setString(4, tilaus.getAsiakas().getPuh());
			prest.setString(5, tilaus.getAsiakas().getEmail());
			prest.setString(6, tilaus.getAsiakas().getOsoite());
			prest.setString(7, tilaus.getAsiakas().getPostnro());
			prest.setString(8, tilaus.getAsiakas().getKaupunki());

			// ajetaan prest
			prest.executeQuery();
			
			ResultSet rs = prest.getGeneratedKeys();
			
			int lastId = 0;
			if(rs.next()) {
				lastId = rs.getInt(1);
			}
									
			// luodaan tilaus
			String sqlTilaus = "insert into tilaus(asiakas_id, kokonaishinta) values (?,?)";
			PreparedStatement prest2 = yhteys.prepareStatement(sqlTilaus);

			prest2.setInt(1, lastId);
			prest2.setDouble(2, tilaus.getHinta());
			prest2.executeQuery();
					
			ResultSet rs2 = prest2.getGeneratedKeys();
			
			int lastId2 = 0;
			if(rs2.next()) {
				lastId2 = rs2.getInt(1);
			}

			for (int i = 0; i < tilaus.getOstoskori().getOstokset().size(); i++) {

				String sqlKori = "insert into tilausrivi(pizza_id, juoma_id, kpl, hinta, oreg, vsip, tilaus_id) values(?,?,?,?,?,?,?)";
				PreparedStatement lauseKori = yhteys.prepareStatement(sqlKori);

				// haetaan ostoskorin sis‰ltˆ arraylistiin
				ArrayList<Ostos> ostokset = tilaus.getOstoskori().getOstokset();

				// katsotaan onko i:arvon kohdalla pizza vai juoma

				if (ostokset.get(i).getTuote().getClass().getSimpleName()
						.equals("Pizza")) {

					lauseKori.setInt(1, ostokset.get(i).getTuote().getId());
					lauseKori.setString(2, null);

				} else {
					lauseKori.setString(1, null);
					lauseKori.setInt(2, ostokset.get(i).getTuote().getId());

				}
						//asetetaan muut arvot
				lauseKori.setInt(3, ostokset.get(i).getLkm());
				lauseKori.setDouble(4, ostokset.get(i).getRivihinta());
				lauseKori.setBoolean(5, ostokset.get(i).isOregano());
				lauseKori.setBoolean(6, ostokset.get(i).isValkosipuli());
				lauseKori.setInt(7, lastId2);

				lauseKori.executeQuery();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			suljeYhteys(yhteys);
		}
	}

}
