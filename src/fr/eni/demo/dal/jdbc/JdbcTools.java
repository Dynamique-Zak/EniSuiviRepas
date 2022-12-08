
package fr.eni.demo.dal.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class JdbcTools {

    public static Connection getConnection() throws IOException, SQLException {
    	Connection cnx = null;
    	
    	//Création d'un objet de type Context permettant la recherche d'une ressource nommée dans l'arbre JNDI
		try {
			Context context = new InitialContext();
			
			//Recherche de la ressource
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			
			//Demande d'une connexion. La méthode getConnection met la demande en attente tant qu'il n'y a pas de connexion disponible
			cnx = dataSource.getConnection();
			
			//Exploitation de la connexion
			System.out.println("La connexion est "+ (cnx.isClosed()?"fermée":"ouverte")+".");
			
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			System.out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
		
			cnx.close();
		}
		
        return cnx;
    }

    // méthodes de conversions de dates, attention, elles ne prenent pas en compte les fuseaux horaires.
    static java.sql.Date toSql( java.time.LocalDate value ) {
        return value == null ? null : java.sql.Date.valueOf( value );
    }

    static java.sql.Time toSql( java.time.LocalTime value ) {
        return value == null ? null : java.sql.Time.valueOf( value );
    }

    static java.sql.Timestamp toSql( java.time.LocalDateTime value ) {
        return value == null ? null : java.sql.Timestamp.valueOf( value );
    }

    static java.time.LocalDate toLocalDate( java.sql.Date value ) {
        return value == null ? null : value.toLocalDate();
    }

    static java.time.LocalTime toLocalTime( java.sql.Time value ) {
        return value == null ? null : value.toLocalTime();
    }

    static java.time.LocalDateTime toLocalDate( java.sql.Timestamp value ) {
        return value == null ? null : value.toLocalDateTime();
    }

}
