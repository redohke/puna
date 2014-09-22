package fi.omapizzeria.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.Pizza;
import fi.omapizzeria.admin.dao.DAOPoikkeus;
import fi.omapizzeria.admin.dao.DBConnectionProperties;

public class PizzaDAO {

	// ajuri
	public PizzaDAO() throws DAOPoikkeus {
		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
		}
	}

	// avaa yhteys metodi
	private Connection avaaYhteys() throws DAOPoikkeus {
		try {
			return DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen ep‰onnistui", e);
		}
	}

	// sulje yhteys metodi
	private void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			throw new DAOPoikkeus(
					"Tietokantayhteys ei jostain syyst‰ mene kiinni.", e);
		}
	}

	public List<Pizza> haePizzat() throws DAOPoikkeus {

		// luodaan pizzoille arraylist
		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();

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

				// lis‰t‰‰n pizza listaan
				Pizza p = new Pizza(id, nimi, hinta);
				pizzat.add(p);
			}

		} catch (Exception e) {
			// heit‰ virhe jos virhe
			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

		// palautetaan pizzat
		return pizzat;

	}

	public void lisaaPizza(Pizza p) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		// pizzojen haku
		try {
			// sql-lause pohja
			String sql = "insert into pizza(nimi, hinta) values(?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// t‰ytet‰‰n puuttuvat tiedot
			lause.setString(1, p.getNimi());
			lause.setDouble(2, p.getHinta());

			// suoritetaan lause
			lause.executeUpdate();

			// consoleen pitsan lis‰ys
			System.out.println("lis‰ttiin seuraavat pizzat: " + p);

		} catch (Exception e) {
			// ehk‰ virhe
			throw new DAOPoikkeus("Pizzan lis‰yksest‰ virhe", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}

	}

	public void poistaPizza(Pizza p) throws DAOPoikkeus {

		// avataan yhteys
		Connection yhteys = avaaYhteys();

		try {
			// sql alustus
			String sql = "delete from pizza where id=?";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// laitetaan pizzan id sql stringiin
			lause.setInt(1, p.getId());

			// suoritus
			lause.executeUpdate();

			// consoleen pizzan poisto
			System.out.println("poistettiin pizza: " + p);

		} catch (Exception e) {
			// ehk‰ virhe
			throw new DAOPoikkeus("Pizzan lis‰yksest‰ virhe", e);
		} finally {
			// yhteys kii
			suljeYhteys(yhteys);
		}
	}

}
