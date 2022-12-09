package fr.eni.demo.bo;

public class Meal{

	private int id;
	private String date;
	private int hour;
	private String aliments;
	
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
	
	public Meal(int id, String date, int hour, String aliments) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.aliments = aliments;
	}
	
	public Meal(String date, int hour, String aliments) {
		super();
		this.id = -1;
		this.date = date;
		this.hour = hour;
		this.aliments = aliments;
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

	public String getAliments() {
		return aliments;
	}

	public void setAliments(String aliments) {
		this.aliments = aliments;
	}
	
}
