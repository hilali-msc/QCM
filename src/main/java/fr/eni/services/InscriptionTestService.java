package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bean.Inscription_test;
import fr.eni.bean.Test;
import fr.eni.bean.Utilisateur;
import fr.eni.dao.InscriptionTestDAO;
import fr.eni.dao.TestDAO;
import fr.eni.dao.UtilisateurDAO;

public class InscriptionTestService {
	
	public static List<Inscription_test> getInscriptionsTest(
			Inscription_test inscriptionTest, Utilisateur user, Test test) throws SQLException {

		try {
			
			if (user.getId_user() > 0) {
				UtilisateurDAO.rechercheParId(user.getId_user());
			}
			if (test.getNom() != null) {
				TestDAO.getTests(test);
			}
			List<Inscription_test> listInscriptionTest= new ArrayList<Inscription_test>();		
			listInscriptionTest = InscriptionTestDAO.getTests(inscriptionTest);
			return listInscriptionTest;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	public void insert (Inscription_test inscription) throws SQLException
	{
		try {
			InscriptionTestDAO.insert(inscription);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	

	public List<Inscription_test> getInscriptionTestByUser (int id_user) throws SQLException
	{
		try {
			return InscriptionTestDAO.getInscriptionTestByUser(id_user);
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
}