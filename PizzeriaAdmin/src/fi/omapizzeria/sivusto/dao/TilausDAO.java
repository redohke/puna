package fi.omapizzeria.sivusto.dao;

import fi.omapizzeria.sivusto.bean.Ostos;
import fi.omapizzeria.sivusto.bean.Tilaus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	//lauseet
	String sqlAsiakas = "insert into asiakas(etunimi, sukunimi, yritys, puhelin, sposti, osoite, postinumero, kaupunki) values(?,?,?,?,?,?,?,?)";
	
	public void lisaaTilaus(Tilaus tilaus) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {
			System.out.println(tilaus);
			
			String sqlAsiakas = "insert into asiakas(etunimi, sukunimi, yritys, puhelin, sposti, osoite, postinumero, kaupunki) values(?,?,?,?,?,?,?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sqlAsiakas);

			// t‰ytet‰‰n puuttuvat tiedot

			lause.setString(1, tilaus.getAsiakas().getEtunimi());
			lause.setString(2, tilaus.getAsiakas().getSukunimi());
			lause.setString(3, tilaus.getAsiakas().getYritys());
			lause.setString(4, tilaus.getAsiakas().getPuh());
			lause.setString(5, tilaus.getAsiakas().getEmail());
			lause.setString(6, tilaus.getAsiakas().getOsoite());
			lause.setString(7, tilaus.getAsiakas().getPostnro());
			lause.setString(8, tilaus.getAsiakas().getKaupunki());

			// asiakas luodaan
			lause.executeQuery();

			
			
			
			
			// haetaan asiakas id
			String sqlAhaku = "SELECT id FROM asiakas ORDER BY id DESC LIMIT 1";
			PreparedStatement lauseAsiakas = yhteys.prepareStatement(sqlAhaku);
			ResultSet rsA = lauseAsiakas.executeQuery();
		

			// asiakas id:n settaus
			int aId = 0;
			if (rsA.next()) {
				aId = rsA.getInt("id");
				System.out.println("asiakas id haun j‰lkeen: " + aId);
			}

			
			
			
			// luodaan tilaus
			String sqlTilaus = "insert into tilaus(asiakas_id, kokonaishinta) values (?,?)";

			PreparedStatement luoTilaus = yhteys.prepareStatement(sqlTilaus);

			luoTilaus.setInt(1, aId);
			luoTilaus.setDouble(2, tilaus.getHinta());
			luoTilaus.executeQuery();

		
			
			// hae tilauksen id

			String sqlThaku = "SELECT id FROM tilaus ORDER BY id DESC LIMIT 1";
			PreparedStatement lauseTilaus = yhteys.prepareStatement(sqlThaku);

			ResultSet rsT = lauseTilaus.executeQuery();

			int tId = 0;
			if (rsT.next()) {
				tId = rsT.getInt("id");
				System.out.println("tilaus id haun j‰lkeen: " + tId);
			}

		
			
			
			
			// tee tilausrivi

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
				lauseKori.setInt(7, tId);

				lauseKori.executeQuery();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			suljeYhteys(yhteys);
		}

		
		
		// http://stackoverflow.com/questions/5513180/java-preparedstatement-retrieving-last-inserted-id
	}

}
