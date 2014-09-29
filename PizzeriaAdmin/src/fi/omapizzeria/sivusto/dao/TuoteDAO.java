package fi.omapizzeria.sivusto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.sivusto.bean.Tuote;
import fi.omapizzeria.admin.dao.DBConnectionProperties;
import fi.omapizzeria.dao.DAOPoikkeus;
import fi.omapizzeria.dao.Yhteys;

public class TuoteDAO {
		
	public List<Tuote> haeTuote() throws DAOPoikkeus {

		// luodaan pizzoille arraylist
		ArrayList<Tuote> tuote = new ArrayList<Tuote>();

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {
			// haetaan pizzat
			String sql = "select id, nimi, hinta from pizza";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);

			// k‰yd‰‰n haku l‰pi
			while (tulokset.next()) {
				int id = tulokset.getInt("id");
				String nimi = tulokset.getString("nimi");
				double hinta = tulokset.getDouble("hinta");
				String tayte1 = tulokset.getString("tayte1");
				String tayte2 = tulokset.getString("tayte2");
				String tayte3 = tulokset.getString("tayte3");
				String tayte4 = tulokset.getString("tayte4");

				// lis‰t‰‰n pizza listaan
				Tuote p = new Tuote(id, nimi, hinta, tayte1, tayte2, tayte3, tayte4);
				tuote.add(p);
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

		// palautetaan pizzat
		return tuote;

	}

}
