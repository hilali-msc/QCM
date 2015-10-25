package fr.eni.services;

import java.util.List;

import fr.eni.bean.Utilisateur;
import fr.eni.dao.UtilisateurDAO;

public class UtilisateurService {

	public static List<Utilisateur> importerListeStagaire() throws Exception {

		try {
			return UtilisateurDAO.importerListeStagiaire();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static Utilisateur rechercheParId(int id) throws Exception {
		try {
			return UtilisateurDAO.rechercheParId(id);
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public void insert(Utilisateur stagiaire) throws Exception {

		try {
			UtilisateurDAO.insert(stagiaire);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void update(Utilisateur stagiaire) throws Exception {

		try {
			UtilisateurDAO.update(stagiaire);;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void delete(Utilisateur stagiaire) throws Exception {
		try {
			UtilisateurDAO.delete(stagiaire);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
