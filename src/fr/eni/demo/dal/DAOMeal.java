package fr.eni.demo.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.demo.bo.Meal;
import fr.eni.demo.dal.jdbc.JdbcTools;

public class DAOMeal extends DAOBase{

	public void insert(Meal meal) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("insert into meal (book_date, book_hour, aliments) values (?, ?, '')");
	        
			// je set les parametres
			stmt.setString(1, meal.getDate());
			stmt.setInt(2, meal.getHour());
			
			// J'execute la requete
			stmt.execute();

	        // Fermer la connexion
	        cnx.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
