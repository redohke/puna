package fi.omapizzeria.yhteys;

import java.sql.Connection;
import java.sql.DriverManager;

import fi.omapizzeria.yhteys.DAOPoikkeus;
import fi.omapizzeria.yhteys.DBConnectionProperties;

public class Yhteys {

	// metodi, joka avaa yhteyden tietokantaan
	public Connection avaaYhteys() throws DAOPoikkeus {
		try {
			return DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));
		} catch (Exception e) {
			throw new DAOPoikkeus("Tietokantayhteyden avaaminen epäonnistui", e);
		}
	}

	// sulje yhteys tietokantaan
	public void suljeYhteys(Connection yhteys) throws DAOPoikkeus {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			throw new DAOPoikkeus(
					"Tietokantayhteys ei jostain syystä mene kiinni.", e);
		}
	}

}
