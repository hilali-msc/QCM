package fr.eni.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionDB {

	private static DataSource pool = null;
	
	/**
	 * Get informations into context.xml to connect the database
	 */
    static {
        InitialContext ic = null;
        try {
            ic = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        } 
        try {
            pool = (DataSource) ic.lookup("java:comp/env/jdbc/GestionQCM");
        } catch (NamingException e) {
            e.printStackTrace();
        } 
    }
    
    /**
     * Give an open connection
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{    	
        Connection connection = null;        
        connection = pool.getConnection();        
        return connection;
    }
	
}
