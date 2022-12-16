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
import javax.ws.rs.core.Response;

import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bll.NoteManager;
import fr.eni.demo.bo.Note;

@Path("note")
public class NoteREST {

	@GET
	@Path("/allVersionCross")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNoteCORS() {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
		
		// Je récupère mes notes
		List<Note> notes = noteManager.getAll();
		
		// Je simule du lag (je dis au thread java d'attendre 1 sec)	
		
		// Je retourne mes notes
		return Response.ok().entity(notes)
				  .header("Access-Control-Allow-Origin", "*")
			         .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllNote() {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
		
		// Je récupère mes notes
		List<Note> notes = noteManager.getAll();
		
		// Je simule du lag (je dis au thread java d'attendre 1 sec)
		
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
	
	@GET
	@Path("/delete/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteNote(@PathParam("id") int id) {
		
		// Je récupère ma BLL/Manager
		NoteManager noteManager = ManagerFactory.getManagerByClass(NoteManager.class);
				
		// J'appel le add de la BLL
		return noteManager.delete(id);
	}

}
