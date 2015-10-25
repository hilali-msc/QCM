package fr.eni.services;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.bean.Inscription_test;
import fr.eni.bean.Test;
import fr.eni.bean.Utilisateur;
import fr.eni.dao.InscriptionTestDAO;
import fr.eni.dao.TestDAO;
import fr.eni.dao.UtilisateurDAO;

public class InscriptionTestService {
	
	public static ArrayList<Inscription_test> getInscriptionsTest(
			Inscription_test inscriptionTest, Utilisateur user, Test test) throws SQLException {

		try {
			
			if (user.getId_user() > 0) {
				UtilisateurDAO.rechercheParId(user.getId_user());
			}
			if (test.getNom() != null) {
				TestDAO.getTests(test);
			}
			ArrayList<Inscription_test> listInscriptionTest= new ArrayList<Inscription_test>();		
			listInscriptionTest = InscriptionTestDAO.getTests(inscriptionTest);
			return listInscriptionTest;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}