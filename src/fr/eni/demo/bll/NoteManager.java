package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Note;
import fr.eni.demo.dal.DAOFactorySimple;

public class NoteManager extends ManagerBase {
	
	public List<Note> getAll(){
		// Select all note depuis la BDD (la DAO)
		List<Note> notes = DAOFactorySimple.getDAONote().selectAll();
		
		return notes;
	}
	
	public boolean add(Note note){
		// Appel DAO insert
		return DAOFactorySimple.getDAONote().insert(note);
	}
	
	public boolean update(Note note){
		// Appel DAO update
		return DAOFactorySimple.getDAONote().update(note);
	}
	
	public boolean delete(int id){
		// Appel DAO delete
		return DAOFactorySimple.getDAONote().delete(id);
	}
	
}
