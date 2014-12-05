package fi.omapizzeria.sivusto.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.bean.Tayte;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
 
 
 
public class AdminDAO extends DAO {
       
public AdminDAO() throws DAOPoikkeus {
               
 
                try {
                        Class.forName(
                                        DBConnectionProperties.getInstance().getProperty("driver"))
                                        .newInstance();
                } catch (Exception e) {
                        throw new DAOPoikkeus("Tietokannan ajuria ei kyetty lataamaan.", e);
                }
        }
       
       
        public void lisaaPizza(Pizza p, List<Integer> tayteLista) throws DAOPoikkeus {
 
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
                       
                        //haetaan uuden pizzan id
                        String sql2 = "SELECT id from pizza ORDER BY id DESC LIMIT 1";
                        Statement haku = yhteys.createStatement();
                        ResultSet rs = haku.executeQuery(sql2);
                        int pId = 0;
                       
                        if (rs.next()){
                                pId = rs.getInt("id");
                        }
                       
                       
                       
                for(int i = 0; i < tayteLista.size(); i++) {
                               
                        //tietokantaan uusi pizza t‰ytteill‰
                        String sql3 = "insert into pizzatayte(pizza_id, tayte_id) values (?,?)";
                        PreparedStatement lause2 = yhteys.prepareStatement(sql3);
               
                       
                        // t‰ytet‰‰n puuttuvat tiedot
                        lause2.setInt(1, pId);
                        lause2.setInt(2, tayteLista.get(i));
                       
                        //suoritetaan lause
                        lause2.executeQuery();
               
                        }
               
 
                        // consoleen pitsan lis‰ys
                        System.out.println("lis‰ttiin seuraavat pizzat: " + p);
 
                } catch (Exception e) {
                        e.printStackTrace();
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
                	
                		int pId = p.getId();
                		
                		System.out.println("pizzaid = " + pId);
                	
                		String sql = "select id from pizzatayte where pizza_id=?";   
                		PreparedStatement haku = yhteys.prepareStatement(sql);
                		haku.setInt(1, pId);
                		ResultSet rs = haku.executeQuery();
                		
                		
                		while (rs.next()) {
                		
                			String poisto = "delete from pizzatayte where id=?";
                			PreparedStatement poistoStatement = yhteys.prepareStatement(poisto);
                			
                			poistoStatement.setInt(1, rs.getInt("id"));
                			
                			poistoStatement.executeUpdate();
                		}
                	           	
                        // sql alustus
                        String sql2 = "delete from pizza where id=?";
                        PreparedStatement lause = yhteys.prepareStatement(sql2);
 
                        // laitetaan pizzan id sql stringiin
                        lause.setInt(1, p.getId());
 
                        // suoritus
                        lause.executeUpdate();
 
                        // consoleen pizzan poisto
                        System.out.println("poistettiin pizza: " + p);
 
                } catch (Exception e) {
                        // ehk‰ virhe
                		e.printStackTrace();
                        throw new DAOPoikkeus("Pizzan poistamisessa virhe", e);
                } finally {
                        // yhteys kii
                        suljeYhteys(yhteys);
                }
        }
        
        
        
        
        
        
        
        
        public ArrayList<Pizza> haePizzatAdmin() throws DAOPoikkeus {
 
                Connection yhteys = null;
                ArrayList<Pizza> pizzalista = new ArrayList<Pizza>();
 
                try {
                        // avataan yhteys tietokantaan
                        yhteys = avaaYhteys();
 
                        // Luodaan sql stringist‰ statement ja suoritetaan sql haku
                        String sql = "select id, nimi, hinta from pizza";
                        Statement haku = yhteys.createStatement();
                        ResultSet rs = haku.executeQuery(sql);
 
                        while (rs.next()) {
                                pizzalista.add(new Pizza(rs.getInt("id"), rs.getString("nimi"),
                                                rs.getDouble("hinta")));
                        }
 
                } catch (Exception e) {
                        // heit‰ virhe jos virhe
                        throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
                } finally {
                        // yhteys kiinni
                        suljeYhteys(yhteys);
                }
                // palautetaan saatu tulos
                return pizzalista;
        }
        
        
        
        
        
        public ArrayList<Tayte> haeTaytelista() throws DAOPoikkeus {

    		Connection yhteys = null;
    		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
    			
    		try {
    			// avataan yhteys tietokantaan
    			yhteys = avaaYhteys();
    			
    			// haetaan taytteet tietokannasta statementill‰ laitetaan haun tulokset ResultSetiksis
    			String sql = "select id, nimi from tayte";
    			PreparedStatement ps = yhteys.prepareStatement(sql);
    			ResultSet rs = ps.executeQuery();
    			
    			while(rs.next()) {
    				taytteet.add(new Tayte(rs.getInt("id"), rs.getString("nimi")));
    			}
    		
    		} catch (Exception e) {
    			// heit‰ virhe jos virhe
    			throw new DAOPoikkeus("Tietokantahaku aiheutti virheen", e);
    		} finally {
    			// yhteys kii
    			suljeYhteys(yhteys);
    		}
    		// palautetaan t‰ytteet
    		return taytteet;
    	}
       
 
 
}