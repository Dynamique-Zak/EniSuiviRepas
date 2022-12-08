package fr.eni.demo.dal;

import java.util.ArrayList;
import java.util.List;

public class DAOFactory {
	
	/*
	public static DAOPerson getDAOPerson() {
		// Si c'est la première fois qu'on recupere (donc si null)
		if (daoPerson == null) {
			daoPerson = new DAOPerson();
		}
		// --
		return daoPerson;
	}
	*/
	
	// private static DAOPerson daoPerson;
	private static List<DAOBase> DAOInstances = new ArrayList<DAOBase>();

	
	/**
	 * Essaye de recuperer une DAO dans la liste
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends DAOBase> T getDAOInList(Class<T> type) {
		for (DAOBase daoBase : DAOInstances) {
			if (daoBase.getClass() == type) {
				return (T) daoBase;
			}
		}
		// Si pas trouvé = null
		return null;
	}
	
	/**
	 * T extends DAOBase = Une classe qui doit au moins hérité de DAOBase
	 * A partir du "type" tout les T vont être remplacé par la valeur de "type" equi est un nom de classe
	 * Example : DAOPerson
	 * @param type Le nom de la classe attendu
	 * @return La DAO entrée en parametre
	 */
	public static <T extends DAOBase> T getDAOByClass(Class<T> type) {
		
		// Par défaut on essaie de prendre une dao deja instancié
		// Si pas trouvé = sinon c'est null
		T object = getDAOInList(type);
		
		try {
			// Si l'objet est null (donc pas trouvé)
			if (object == null) {
				// On instance la dao
				// J'appel le constructeur par défaut de la classe mis en parametre
				object = (T) type.newInstance();
				
				// Ajouter à la liste des dao instanciés
				DAOInstances.add(object);
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// Retourne la dao casté
		return type.cast(object);
	}
}
