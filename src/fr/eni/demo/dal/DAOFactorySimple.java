package fr.eni.demo.dal;

public class DAOFactorySimple {

	private static DAOMeal daoMeal = null;
	private static DAONote daoNote = null;
	
	public static DAOMeal getDAOMeal() {
		if (daoMeal == null) {
			daoMeal = new DAOMeal();
		}
		return daoMeal;
	}
	
	public static DAONote getDAONote() {
		if (daoNote == null) {
			daoNote = new DAONote();
		}
		return daoNote;
	}
}
