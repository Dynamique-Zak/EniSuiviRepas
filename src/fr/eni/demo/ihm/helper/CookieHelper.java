package fr.eni.demo.ihm.helper;

import javax.servlet.http.Cookie;

public class CookieHelper {

	public static Cookie getCookieByName(String Name, Cookie[] cookies) {
		// Si la liste n'est pas null
		if (cookies != null) {
			// Pour chaque cookie
			for (Cookie cookie : cookies) {
				// Je récupère le cookie compteur
				if (cookie.getName().equals(Name)) {
					return cookie;
				}
			}
		}
		
		return null;
	}
}
