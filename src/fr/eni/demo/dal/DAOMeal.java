package fr.eni.demo.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Meal;
import fr.eni.demo.dal.jdbc.JdbcTools;

public class DAOMeal extends DAOBase{

	public DAOMeal() {
		super();
	}
	
	public boolean insert(Meal meal) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("insert into meal (book_date, book_hour, aliments) values (?, ?, ?)");
	        
			// je set les parametres
			stmt.setString(1, meal.getDate());
			stmt.setInt(2, meal.getHour());
			stmt.setString(3, meal.getAliments());
			
			// J'execute la requete
			stmt.execute();

	        // Fermer la connexion
	        cnx.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;	
	}

	public List<Meal> selectAll() {
		// Prepare les var
		Connection cnx = null;
		List<Meal> meals = new ArrayList<Meal>();
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			Statement stmt = cnx.createStatement();
			
			// J'execute la requete
			ResultSet result = stmt.executeQuery("SELECT * FROM meal");

			// Pour chaque chaque ligne récupérée de la BDD
			while (result.next()) {
				// Ajouter un repas dans la liste preparee
				Meal meal = new Meal(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4));
				meals.add(meal);
			}

	        // Fermer la connexion
	        cnx.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Quel soit vide ou pas on retourne la liste
		return meals;	
	}
	
}
