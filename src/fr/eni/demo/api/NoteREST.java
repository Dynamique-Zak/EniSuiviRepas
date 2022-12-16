package fr.eni.demo.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		
		// Je retourne mes notes
		return notes;
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addNote(Note note) {
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
				
		// J'appel le add de la BLL
		return noteManager.add(note);
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateNote(Note note) {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
				
		// J'appel le add de la BLL
		return noteManager.update(note);
	}
	
	@DELETE
	@Path("/delete/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteNote(@PathParam("id") int id) {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
				
		// J'appel le add de la BLL
		return noteManager.delete(id);
	}

}
