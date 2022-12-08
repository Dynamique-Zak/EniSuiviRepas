package fr.eni.demo.bo;

public class Meal {

	private int id;
	private String date;
	private int hour;
	
	public Meal(int id, String date, int hour) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
	}
	
	public Meal(String date, int hour) {
		super();
		this.id = -1;
		this.date = date;
		this.hour = hour;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
}
