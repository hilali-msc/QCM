package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Reponse;
import fr.eni.dao.ReponseDAO;

public class ReponseService {
	
	public static ArrayList<Reponse> getReponses(int idQuestion) throws SQLException {

		try {
			ArrayList<Reponse> listReponses = new ArrayList<Reponse>();		
			listReponses = ReponseDAO.getReponses(idQuestion);
			return listReponses;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static void insert(Reponse reponse) throws SQLException {

		try {
			ReponseDAO.insert(reponse);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Reponse reponse) throws SQLException {

		try {
			ReponseDAO.update(reponse);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Reponse reponse) throws SQLException {

		try {
			ReponseDAO.delete(reponse);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
