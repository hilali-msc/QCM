package fr.eni.services;

import java.util.Vector;

import fr.eni.bean.Utilisateur;
import fr.eni.dao.UtilisateurDAO;

public class UtilisateurService {
	
	public static Vector<Utilisateur> importerListeStagaire(){
		
		Vector<Utilisateur> listeUtilisateur = new Vector<Utilisateur>();		
		listeUtilisateur = UtilisateurDAO.importerListeStagiaire();		
		return listeUtilisateur;
		
	}
	
	public static Utilisateur rechercheParId(int id){
		
		Utilisateur user = new Utilisateur();
		user = UtilisateurService.rechercheParId(id);	
		return user;
		
	}
	
}
