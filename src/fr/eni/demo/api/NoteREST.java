package fr.eni.demo.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bll.NoteManager;
import fr.eni.demo.bo.Note;

@Path("note")
public class NoteREST {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllNote() {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
		
		// Je récupère mes notes
		List<Note> notes = noteManager.getAll();
		
		// Je simule du lag (je dis au thread java d'attendre 1 sec)
	
		try {
		  Thread.sleep(1000);
		} catch (InterruptedException e) {
		  Thread.currentThread().interrupt();
		}
	
		// --
		
		// Je retourne mes notes
		return notes;
	}

}
