package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Reponse_Candidats;
import fr.eni.dao.ReponseCandidatsDAO;

public class ReponseCandidatsService {

	public static ArrayList<Reponse_Candidats> getReponsesCandidats(Reponse_Candidats reponseCandidat) throws SQLException {

		try {
			ArrayList<Reponse_Candidats> listeReponsesCandidats = new ArrayList<Reponse_Candidats>();		
			listeReponsesCandidats = ReponseCandidatsDAO.getReponsesCandidats(reponseCandidat);
			return listeReponsesCandidats;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	public static List<Reponse_Candidats> getReponsesByInscription(int id_inscription) throws SQLException {

		try {
			return ReponseCandidatsDAO.getReponsesByInscription(id_inscription);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	public static void insert(Reponse_Candidats reponseCandidat) throws SQLException {

		try {
			ReponseCandidatsDAO.insert(reponseCandidat);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void update(Reponse_Candidats reponseCandidat) throws SQLException {

		try {
			ReponseCandidatsDAO.update(reponseCandidat);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public static void delete(Reponse_Candidats reponseCandidat) throws SQLException {

		try {
			ReponseCandidatsDAO.delete(reponseCandidat);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}
