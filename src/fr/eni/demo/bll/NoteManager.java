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
	
}
