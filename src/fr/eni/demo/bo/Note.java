package fr.eni.demo.bo;

public class Note {

	private int id;
	private String details;
	
	public Note() {}
	
	public Note(int id, String details) {
		super();
		this.id = id;
		this.details = details;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
