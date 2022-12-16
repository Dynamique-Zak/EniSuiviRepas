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
import fr.eni.demo.bo.Note;
import fr.eni.demo.dal.jdbc.JdbcTools;

public class DAONote extends DAOBase{

	public DAONote() {
		super();
	}
	
	public List<Note> selectAll() {
		// Prepare les var
		Connection cnx = null;
		List<Note> notes = new ArrayList<Note>();
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			Statement stmt = cnx.createStatement();
			
			// J'execute la requete
			ResultSet result = stmt.executeQuery("SELECT * FROM note");

			// Pour chaque chaque ligne récupérée de la BDD
			while (result.next()) {
				// Ajouter un note dans la liste preparee
				Note note = new Note(result.getInt(1), result.getString(2));
				notes.add(note);
			}

	        // Fermer la connexion
	        cnx.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Quel soit vide ou pas on retourne la liste
		return notes;	
	}

	public boolean insert(Note note) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO note (details) VALUES (?)");
			
			// Remplacer les params
			// -- detail
			stmt.setString(1, note.getDetails());
			
			// J'execute la requete
			stmt.execute();

	        // Fermer la connexion
	        cnx.close();
	        
	        return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Quel soit vide ou pas on retourne la liste
		return false;	
	}

	public boolean update(Note note) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("UPDATE note SET details=? WHERE id=?");
			
			// Remplacer les params
			// -- detail
			stmt.setString(1, note.getDetails());
			stmt.setInt(2, note.getId());
			
			// J'execute la requete
			stmt.execute();

	        // Fermer la connexion
	        cnx.close();
	        
	        return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Quel soit vide ou pas on retourne la liste
		return false;	
	}
	
	public boolean delete(int Id) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("DELETE FROM note WHERE id=?");
			stmt.setInt(1, Id);
			
			// Executer la requete
	        stmt.execute();
	        
	        // Fermer la connexion
	        cnx.close();
	        
	        return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return false;
	}

}
