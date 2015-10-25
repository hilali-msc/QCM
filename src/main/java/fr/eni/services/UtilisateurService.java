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
	
	public static Utilisateur rechercheParId(int id){
		
		Utilisateur user = new Utilisateur();
		user = UtilisateurService.rechercheParId(id);	
		return user;
		
	}
	
	public void insert(Utilisateur stagiaire) throws Exception {
		
		try {
			UtilisateurDAO.insert(stagiaire);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
}
