package fi.omapizzeria.sivusto.service;
 
 
 
import java.util.ArrayList;
import java.util.List;
 
import fi.omapizzeria.sivusto.bean.Pizza;
import fi.omapizzeria.sivusto.dao.AdminDAO;
import fi.omapizzeria.sivusto.dao.DAOPoikkeus;
 
public class AdminService {
       
        public AdminService() throws DAOPoikkeus {
                super();
        }
       
        public void viePizza(Pizza p, String[] taytteet) throws DAOPoikkeus{
                       
                AdminDAO dao = new AdminDAO();
                       
                List<Integer> tayteLista = new ArrayList<Integer>();
                             
                for(String s : taytteet) {
                           tayteLista.add(Integer.parseInt(s));
                        }
                                        
                dao.lisaaPizza(p, tayteLista);
               
                }
               
               
       
               
               
        }